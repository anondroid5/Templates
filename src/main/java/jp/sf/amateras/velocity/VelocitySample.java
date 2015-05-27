package jp.sf.amateras.velocity;

import java.io.StringWriter;
import java.util.Properties;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

public class VelocitySample {

	public static void main(String[] args) {

		// Velocityエンジンの初期化
		Properties prop = new Properties();
		prop.setProperty("resource.loader", "class");
		prop.setProperty("class.resource.loader.class",
		  "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
		prop.setProperty("class.resource.loader.cache", "true");
		prop.setProperty("input.encoding", "UTF-8");

		VelocityEngine engine = new VelocityEngine();
		engine.init(prop);

		// テンプレートへ渡す値を設定
		VelocityContext context = new VelocityContext();
		context.put("name", "山田太郎");
		context.put("today", "2011/01/30 20:30");
		context.put("number", "00000-11111-22222");

		// クラスパスからテンプレートファイルを取得
		Template template = engine.getTemplate("test.vm");

		// TemplateにVelocityContextをマージ
		StringWriter writer = new StringWriter();
		template.merge(context, writer);

		// マージ結果を表示
		System.out.println(writer.toString());
	}
}
