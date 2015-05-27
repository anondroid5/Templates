package jp.sf.amateras.freemarker;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class FreemarkerSample {

	public static void main(String[] args) throws IOException,
			TemplateException {

		// Configurationのインスタンス生成
		Configuration cfg = new Configuration();
		cfg.setDirectoryForTemplateLoading(new File("template"));

		// Mapへデータを設定
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "山田太郎");
		map.put("today", "2011/01/30 20:30");
		map.put("number", "00000-11111-22222");

		// Templateを取得
		Template temp = cfg.getTemplate("test.ftl");
		Writer out = new OutputStreamWriter(System.out);
		temp.process(map, out);
		out.flush();
	}
}
