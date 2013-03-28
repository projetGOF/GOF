package gof.edition;

import java.util.ArrayList;
import java.util.List;
 
import com.ckeditor.CKEditorConfig;
import com.ckeditor.EventHandler;
import com.ckeditor.GlobalEventHandler;
 
public class ConfigurationHelper {
 
	public static CKEditorConfig createConfig() {
		CKEditorConfig config = new CKEditorConfig();
		List<List<String>> list = new ArrayList<List<String>>();
		List<String> subList = new ArrayList<String>();
		subList.add("Source");
		subList.add("Save");
		subList.add("-");
		subList.add("Format");
		subList.add("Bold");
		//subList.add("Italic");
		subList.add("BulletedList");
		subList.add("-");
		subList.add("Link");
		subList.add("Unlink");
		subList.add("Undo");
		subList.add("Redo");
		list.add(subList);
		config.addConfigValue("toolbar", list);
		config.addConfigValue("width","500");
		config.addConfigValue("entities", false);
		config.addConfigValue("entities_latin",false);
		config.addConfigValue("basicEntities",false);
		config.addConfigValue("entities_processNumerical",false);
		config.addConfigValue("language","fr");
		 
			
		return config;
	}
 
	public static EventHandler createEventHandlers() {
		EventHandler handler = new EventHandler();
		//handler.addEventHandler("instanceReady","function (ev) { alert(\"Loaded: \" + ev.editor.name); }");
		handler.addEventHandler("instanceReady","function (ev) { }");
		return handler;
	}
 
	public static GlobalEventHandler createGlobalEventHandlers() {
		GlobalEventHandler handler = new GlobalEventHandler();
		//handler.addEventHandler("dialogDefinition","function (ev) {  alert(\"Loading dialog window: \" + ev.data.name); }");
		handler.addEventHandler("dialogDefinition","function (ev) { }");
		return handler;
	}
}