package com.zy.gis.controller.management;

import com.alibaba.fastjson.JSONObject;
import com.zy.gis.common.response.ResponseJSONObject;
import com.zy.gis.pojo.OrganizeRegionInfo;
import com.zy.gis.service.OrganizeRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author hhp
 * @date 2021/9/28 14:37
 */
@Controller
public class OrganizeRegionController {

    @Autowired
    OrganizeRegionService organizeRegionService;

    /**
     * @Description:批量新增区域所属范围点位
     * @author hhp
     * @date 2021/9/28 15:06
     * @param organizeRegionInfoList:
     * @return {@link JSONObject}
     */
    @RequestMapping(value = "insertOrganizeRegionList",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject insertOrganizeRegionList(@RequestBody List<OrganizeRegionInfo> organizeRegionInfoList){
        System.out.println("----------------------->"+organizeRegionInfoList);
        int iRet = organizeRegionService.insertOrganizeRegionList(organizeRegionInfoList);
        return ResponseJSONObject.retMsg(iRet,"新增区域所属范围点位信息");
    }

    /**
     * @Description:删除区域所属范围点位
     * @author hhp
     * @date 2021/9/28 15:08
     * @param organizeRegionInfo:
     * @return {@link JSONObject}
     */
    @RequestMapping(value = "delOrganizeRegion",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject delOrganizeRegion(OrganizeRegionInfo organizeRegionInfo){
        int iRet = organizeRegionService.deleteByOrganizeId(organizeRegionInfo.getOrganizeId());
        return ResponseJSONObject.retMsg(iRet,"删除区域所属范围点位信息");
    }


    /**
     * @Description:获取区域所属范围点位集合
     * @author hhp
     * @date 2021/9/28 15:20
     * @param organizeRegionInfo:
     * @return {@link List< OrganizeRegionInfo>}
     */
    @RequestMapping(value = "getRegionData",method = RequestMethod.POST)
    @ResponseBody
    public List<OrganizeRegionInfo> getRegionData(OrganizeRegionInfo organizeRegionInfo){

        List<OrganizeRegionInfo> regionInfoList = organizeRegionService.selectRegionInfo(organizeRegionInfo);

        return regionInfoList;
    }

    public void testAddRegion(){
        //长河街道手动绘制点位信息
        String a = "{organizeId: '4', longitude: 120.17641441104455, latitude: 30.201054980578576}\n" +
                "{organizeId: '4', longitude: 120.17984459395812, latitude: 30.19373869655886}\n" +
                "{organizeId: '4', longitude: 120.18072049204562, latitude: 30.19028469782883}\n" +
                "{organizeId: '4', longitude: 120.18091845720033, latitude: 30.18703206037496}\n" +
                "{organizeId: '4', longitude: 120.18111768546247, latitude: 30.183215433480342}\n" +
                "{organizeId: '4', longitude: 120.17760723760411, latitude: 30.183372389791703}\n" +
                "{organizeId: '4', longitude: 120.17740587101554, latitude: 30.180534195851877}\n" +
                "{organizeId: '4', longitude: 120.18035619071385, latitude: 30.18036109051091}\n" +
                "{organizeId: '4', longitude: 120.18058836091699, latitude: 30.179249133329446}\n" +
                "{organizeId: '4', longitude: 120.18038577640583, latitude: 30.177360805944474}\n" +
                "{organizeId: '4', longitude: 120.18095234352994, latitude: 30.175433435850707}\n" +
                "{organizeId: '4', longitude: 120.18184396879099, latitude: 30.175750608864284}\n" +
                "{organizeId: '4', longitude: 120.18290839236946, latitude: 30.17380647030993}\n" +
                "{organizeId: '4', longitude: 120.18366986546889, latitude: 30.174024904783103}\n" +
                "{organizeId: '4', longitude: 120.18440763174695, latitude: 30.17284992416556}\n" +
                "{organizeId: '4', longitude: 120.18626693622709, latitude: 30.17142698751762}\n" +
                "{organizeId: '4', longitude: 120.18652904937828, latitude: 30.17082332917789}\n" +
                "{organizeId: '4', longitude: 120.1875879732609, latitude: 30.171119691305964}\n" +
                "{organizeId: '4', longitude: 120.18778826718284, latitude: 30.17062570633714}\n" +
                "{organizeId: '4', longitude: 120.18841514752702, latitude: 30.170523345319477}\n" +
                "{organizeId: '4', longitude: 120.19240990727906, latitude: 30.168575097202083}\n" +
                "{organizeId: '4', longitude: 120.19177442305451, latitude: 30.167133719221532}\n" +
                "{organizeId: '4', longitude: 120.19189632589696, latitude: 30.16559954659535}\n" +
                "{organizeId: '4', longitude: 120.18992248315243, latitude: 30.165208435028063}\n" +
                "{organizeId: '4', longitude: 120.18981833442008, latitude: 30.16434863987784}\n" +
                "{organizeId: '4', longitude: 120.19187040071012, latitude: 30.164298992389735}\n" +
                "{organizeId: '4', longitude: 120.1902834345233, latitude: 30.161609018390095}\n" +
                "{organizeId: '4', longitude: 120.18988446353953, latitude: 30.160740513070554}\n" +
                "{organizeId: '4', longitude: 120.18886047619547, latitude: 30.160437027137945}\n" +
                "{organizeId: '4', longitude: 120.18638977770897, latitude: 30.162259197116366}\n" +
                "{organizeId: '4', longitude: 120.1864119938822, latitude: 30.159916629216696}\n" +
                "{organizeId: '4', longitude: 120.18486229506723, latitude: 30.161907328634147}\n" +
                "{organizeId: '4', longitude: 120.18323887708013, latitude: 30.160835219794162}\n" +
                "{organizeId: '4', longitude: 120.18142295895952, latitude: 30.15840910310528}\n" +
                "{organizeId: '4', longitude: 120.18270190085812, latitude: 30.156375147629245}\n" +
                "{organizeId: '4', longitude: 120.18437069414301, latitude: 30.156610183659403}\n" +
                "{organizeId: '4', longitude: 120.18615924071507, latitude: 30.155253022732637}\n" +
                "{organizeId: '4', longitude: 120.18697028231256, latitude: 30.155409443966754}\n" +
                "{organizeId: '4', longitude: 120.18930480298378, latitude: 30.150408043733858}\n" +
                "{organizeId: '4', longitude: 120.19338267117682, latitude: 30.1515195067063}\n" +
                "{organizeId: '4', longitude: 120.192463035672, latitude: 30.148899517397172}\n" +
                "{organizeId: '4', longitude: 120.19910222772329, latitude: 30.15108751577885}\n" +
                "{organizeId: '4', longitude: 120.19982409965314, latitude: 30.149765631944422}\n" +
                "{organizeId: '4', longitude: 120.20055912286549, latitude: 30.149940864714363}\n" +
                "{organizeId: '4', longitude: 120.2021065848997, latitude: 30.148044156869673}\n" +
                "{organizeId: '4', longitude: 120.20331620105873, latitude: 30.14891882384171}\n" +
                "{organizeId: '4', longitude: 120.20398462938024, latitude: 30.147635719791655}\n" +
                "{organizeId: '4', longitude: 120.20811859315916, latitude: 30.145484381131674}\n" +
                "{organizeId: '4', longitude: 120.21123168419892, latitude: 30.146888978620552}\n" +
                "{organizeId: '4', longitude: 120.21158125206269, latitude: 30.1486162740543}\n" +
                "{organizeId: '4', longitude: 120.21513227251822, latitude: 30.144930915568246}\n" +
                "{organizeId: '4', longitude: 120.2165333686052, latitude: 30.144906897998833}\n" +
                "{organizeId: '4', longitude: 120.21352561224073, latitude: 30.14093530908859}\n" +
                "{organizeId: '4', longitude: 120.21759452423802, latitude: 30.13881327562613}\n" +
                "{organizeId: '4', longitude: 120.22057954215445, latitude: 30.141686716624793}\n" +
                "{organizeId: '4', longitude: 120.22267217277721, latitude: 30.14143014957702}\n" +
                "{organizeId: '4', longitude: 120.22652865860788, latitude: 30.145814820039682}\n" +
                "{organizeId: '4', longitude: 120.22290889765878, latitude: 30.148096254494828}\n" +
                "{organizeId: '4', longitude: 120.22292654900272, latitude: 30.149007961833142}\n" +
                "{organizeId: '4', longitude: 120.22354744348817, latitude: 30.149665965940184}\n" +
                "{organizeId: '4', longitude: 120.22430613893714, latitude: 30.149738195314324}\n" +
                "{organizeId: '4', longitude: 120.22462831054895, latitude: 30.15122810044689}\n" +
                "{organizeId: '4', longitude: 120.22513770555788, latitude: 30.151653322682755}\n" +
                "{organizeId: '4', longitude: 120.22632667200887, latitude: 30.15311783468739}\n" +
                "{organizeId: '4', longitude: 120.22796453995875, latitude: 30.153572653759568}\n" +
                "{organizeId: '4', longitude: 120.22828399994556, latitude: 30.15518685459777}\n" +
                "{organizeId: '4', longitude: 120.22887296892267, latitude: 30.15532328953181}\n" +
                "{organizeId: '4', longitude: 120.23071433082823, latitude: 30.158599709937143}\n" +
                "{organizeId: '4', longitude: 120.23282755726076, latitude: 30.15812993370681}\n" +
                "{organizeId: '4', longitude: 120.23454060898017, latitude: 30.158459585154734}\n" +
                "{organizeId: '4', longitude: 120.23441342437079, latitude: 30.160330372858823}\n" +
                "{organizeId: '4', longitude: 120.232037123151, latitude: 30.162608662946017}\n" +
                "{organizeId: '4', longitude: 120.23173234138639, latitude: 30.163444867507785}\n" +
                "{organizeId: '4', longitude: 120.23276512125496, latitude: 30.166909613962275}\n" +
                "{organizeId: '4', longitude: 120.23175244079253, latitude: 30.168476147382133}\n" +
                "{organizeId: '4', longitude: 120.23203386293083, latitude: 30.169899828792467}\n" +
                "{organizeId: '4', longitude: 120.23059429143073, latitude: 30.16979915625771}\n" +
                "{organizeId: '4', longitude: 120.22785700928583, latitude: 30.168822204860795}\n" +
                "{organizeId: '4', longitude: 120.22715643788639, latitude: 30.166995471693625}\n" +
                "{organizeId: '4', longitude: 120.22576510431422, latitude: 30.166899389051867}\n" +
                "{organizeId: '4', longitude: 120.22299339173607, latitude: 30.166447076124733}\n" +
                "{organizeId: '4', longitude: 120.2209776601073, latitude: 30.166090578759572}\n" +
                "{organizeId: '4', longitude: 120.22090585109194, latitude: 30.16806564484884}\n" +
                "{organizeId: '4', longitude: 120.22062329259718, latitude: 30.168329615506213}\n" +
                "{organizeId: '4', longitude: 120.21964566976492, latitude: 30.16825228305043}\n" +
                "{organizeId: '4', longitude: 120.2147661250788, latitude: 30.16670658026972}\n" +
                "{organizeId: '4', longitude: 120.21452540192924, latitude: 30.166876613198287}\n" +
                "{organizeId: '4', longitude: 120.21471861909019, latitude: 30.16767219396889}\n" +
                "{organizeId: '4', longitude: 120.21337914083242, latitude: 30.16900250578594}\n" +
                "{organizeId: '4', longitude: 120.2130028419119, latitude: 30.16838690593712}\n" +
                "{organizeId: '4', longitude: 120.21208509518424, latitude: 30.16956460401237}\n" +
                "{organizeId: '4', longitude: 120.21257980837777, latitude: 30.170946279905404}\n" +
                "{organizeId: '4', longitude: 120.21392895806216, latitude: 30.1713890354519}\n" +
                "{organizeId: '4', longitude: 120.21312032940313, latitude: 30.1743200353313}\n" +
                "{organizeId: '4', longitude: 120.21116476951131, latitude: 30.18122291425739}\n" +
                "{organizeId: '4', longitude: 120.2114106354599, latitude: 30.182515982248564}\n" +
                "{organizeId: '4', longitude: 120.20968338287786, latitude: 30.182497064490256}\n" +
                "{organizeId: '4', longitude: 120.20961078011975, latitude: 30.187491229678336}\n" +
                "{organizeId: '4', longitude: 120.2138166915226, latitude: 30.18754443390083}\n" +
                "{organizeId: '4', longitude: 120.21367240614073, latitude: 30.189148799017264}\n" +
                "{organizeId: '4', longitude: 120.21366741928752, latitude: 30.190172919982814}\n" +
                "{organizeId: '4', longitude: 120.21747068419975, latitude: 30.19021998948072}\n" +
                "{organizeId: '4', longitude: 120.21737799470161, latitude: 30.192885567942376}\n" +
                "{organizeId: '4', longitude: 120.22464675913905, latitude: 30.193193778570937}\n" +
                "{organizeId: '4', longitude: 120.22474467533796, latitude: 30.19857027433113}\n" +
                "{organizeId: '4', longitude: 120.22236312513942, latitude: 30.198629677657472}\n" +
                "{organizeId: '4', longitude: 120.22210622233985, latitude: 30.20006769634704}\n" +
                "{organizeId: '4', longitude: 120.22079649784698, latitude: 30.199465602298634}\n" +
                "{organizeId: '4', longitude: 120.22121549233003, latitude: 30.202685462141478}\n" +
                "{organizeId: '4', longitude: 120.216937472866, latitude: 30.202479617617097}\n" +
                "{organizeId: '4', longitude: 120.21682253162173, latitude: 30.204713677188334}\n" +
                "{organizeId: '4', longitude: 120.22087184420975, latitude: 30.205267676976277}\n" +
                "{organizeId: '4', longitude: 120.22030005361874, latitude: 30.209924432359916}\n" +
                "{organizeId: '4', longitude: 120.21986723969351, latitude: 30.211866210209692}\n" +
                "{organizeId: '4', longitude: 120.219340547273, latitude: 30.211809778691382}\n" +
                "{organizeId: '4', longitude: 120.21886264362138, latitude: 30.21185994941415}\n" +
                "{organizeId: '4', longitude: 120.21837015427299, latitude: 30.212231242950583}\n" +
                "{organizeId: '4', longitude: 120.21655798532024, latitude: 30.21479621236409}\n" +
                "{organizeId: '4', longitude: 120.21519012195577, latitude: 30.21668331591428}\n" +
                "{organizeId: '4', longitude: 120.2196822379856, latitude: 30.219893342511526}\n" +
                "{organizeId: '4', longitude: 120.21636712845701, latitude: 30.22321074519167}\n" +
                "{organizeId: '4', longitude: 120.21428602489051, latitude: 30.220962120872954}\n" +
                "{organizeId: '4', longitude: 120.21083518265698, latitude: 30.219376080417838}\n" +
                "{organizeId: '4', longitude: 120.21041045464916, latitude: 30.21901177754912}\n" +
                "{organizeId: '4', longitude: 120.20681944854927, latitude: 30.21744664146634}\n" +
                "{organizeId: '4', longitude: 120.20554419239815, latitude: 30.21615245535844}\n" +
                "{organizeId: '4', longitude: 120.20342928739193, latitude: 30.215382772960485}\n" +
                "{organizeId: '4', longitude: 120.1994527750994, latitude: 30.21363406817382}\n" +
                "{organizeId: '4', longitude: 120.19961351034158, latitude: 30.212927770956238}\n" +
                "{organizeId: '4', longitude: 120.19928926103894, latitude: 30.2127126256941}\n" +
                "{organizeId: '4', longitude: 120.19873969254998, latitude: 30.213268162308317}\n" +
                "{organizeId: '4', longitude: 120.1969727181559, latitude: 30.212536342943437}\n" +
                "{organizeId: '4', longitude: 120.19649140875859, latitude: 30.212118580513014}\n" +
                "{organizeId: '4', longitude: 120.19441673149005, latitude: 30.21095226611052}\n" +
                "{organizeId: '4', longitude: 120.19414141720041, latitude: 30.21098116908994}\n" +
                "{organizeId: '4', longitude: 120.1923012186903, latitude: 30.21023478373002}\n" +
                "{organizeId: '4', longitude: 120.19055140211114, latitude: 30.209470434305377}\n" +
                "{organizeId: '4', longitude: 120.18917348446227, latitude: 30.208656762956814}\n" +
                "{organizeId: '4', longitude: 120.18842453967046, latitude: 30.208026507567272}\n" +
                "{organizeId: '4', longitude: 120.18718864861425, latitude: 30.20670151733298}\n" +
                "{organizeId: '4', longitude: 120.18584553230896, latitude: 30.20598177640372}\n" +
                "{organizeId: '4', longitude: 120.18426665087172, latitude: 30.205089516089014}\n" +
                "{organizeId: '4', longitude: 120.18345366084961, latitude: 30.20457486624937}\n" +
                "{organizeId: '4', longitude: 120.1809950151976, latitude: 30.20346755027647}\n" +
                "{organizeId: '4', longitude: 120.17894152635097, latitude: 30.201897133372153}\n";

        String[] array = a.split("\\{");
        List<OrganizeRegionInfo> organizeRegionInfoList = new ArrayList<>();
        for(int i=1; i<array.length; i++){

            String longitude = array[i].substring(array[i].indexOf("longitude: ")+11,array[i].indexOf(", latitude: "));
            String latitude = array[i].substring(array[i].indexOf("latitude: ")+10,array[i].indexOf("}"));
            OrganizeRegionInfo organizeRegionInfo = new OrganizeRegionInfo();
            organizeRegionInfo.setOrganizeId(4);
            organizeRegionInfo.setLongitude(longitude);
            organizeRegionInfo.setLatitude(latitude);
            organizeRegionInfoList.add(organizeRegionInfo);
        }
        insertOrganizeRegionList(organizeRegionInfoList);
    }
}
