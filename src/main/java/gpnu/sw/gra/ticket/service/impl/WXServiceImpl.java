package gpnu.sw.gra.ticket.service.impl;

import gpnu.sw.gra.ticket.service.WXService;
import gpnu.sw.gra.ticket.util.HttpClientUtil;
import gpnu.sw.gra.ticket.util.JsonUtil;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Auther:S
 * @Date:20/3/26
 */
@Service
public class WXServiceImpl implements WXService {

    String appid = "wxada6bc475775f769";
    String appSct="0353b7953f3f690876d7f00ebe6a68a0";
    String url = "https://api.weixin.qq.com/sns/jscode2session?appid=%s&secret=%s&js_code=%s&grant_type=authorization_code";

    @Override
    public String getOpenId(String code) {
        String oid = null;
        Map<String, Object> map = JsonUtil.jsonToMap(code);
        code = map.get("code").toString();
        String _url = String.format(url, appid, appSct,code);
        String res = HttpClientUtil.doGet(_url);
        System.out.println(res);
        return res;
    }
}
