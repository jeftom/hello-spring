package com.yuntao.hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.ModelMap;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPoolConfig;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Set;

/**
 * class description
 *
 * @author jeftom
 * @date 17/12/23 20:41
 * @since 1.0.0
 */
@Controller
@RequestMapping(value = "/", method = RequestMethod.GET)
public class IndexController {
	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
	/**
	 * 默认首页方法
	 * 这里的 RequestMapping value 要写成空的，才能用 /hello 访问到
	 * @param model
	 * @return string
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String index(ModelMap model) {
		model.addAttribute("msg", "fuck Spring MVC mother index");
		model.addAttribute("name", "SpringMother");

		try {
			// Redis 操作
			Jedis jedis = new Jedis("10.100.86.50", 6379);
			jedis.auth("freshjn123");

			// 查询 string 类型
			System.out.println(jedis.get("admin:sale_time:103106107:1"));

			// 查询 hash 类型
			Set<String> hkeys = jedis.hkeys("regions:101101");
			System.out.println(hkeys);

			// 查询 zset 类型
			Set<String> zsets = jedis.zrange("REGIONGROUP:101101101101", 0, -1);
			System.out.println("OrderEditAddress" + zsets);

			// 查询 list 类型
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// Redis 连接池
//		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
//		jedisPoolConfig.setBlockWhenExhausted(true);
//		jedisPoolConfig.setEvictionPolicyClassName("org.apache.commons.pool2.impl.DefaultEvictionPolicy");
//		jedisPoolConfig.setJmxEnabled(true);
//		jedisPoolConfig.setJmxNamePrefix("pool");

		// write log
		logger.error("written a logger");
		logger.info("写个日志试一下");

		OkHttpClient client = new OkHttpClient();

		String url = "http://www.tenwe.com";

		try {
			Request request = new Request.Builder().url(url).build();
			Response response = client.newCall(request).execute();
//			System.out.println(response.body().string());
			model.addAttribute("response", response.body().string());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		return "index";
	}
}
