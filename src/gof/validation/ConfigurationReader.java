package gof.validation;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class ConfigurationReader {

	private static ConfigurationReader instance;
	private static Map<String,Map<String,DataType>> fiches;
	
	protected ConfigurationReader(){
		
		fiches = new HashMap<String, Map<String,DataType>>();
		
		/*
		 * lecture du fichier properties
		 */
		
		String path = System.getProperty("user.dir")+"\\src\\gof\\validation\\fiches-validation.properties";
		
		Properties properties = new Properties();
		try	{
				System.out.println(path);
				properties.load(new FileInputStream(path));
			}
		catch (IOException e){
				e.printStackTrace();
			}
		
		/*
		 * initialisation de la liste de types de données
		 */
		
		List<DataType> dataTypeList = new ArrayList<DataType>();
		for(String currentType : Arrays.asList(properties.get("datatypes").toString().split(","))){
			DataType dataType = new DataType();
			dataType.setName(currentType);
			dataType.setExpression(properties.get("datatypes."+currentType+".expression").toString());
			dataType.setDescription(properties.get("datatypes."+currentType+".description").toString());
			dataType.setExample(properties.get("datatypes."+currentType+".example").toString());
			dataTypeList.add(dataType);
		}
		
		/*
		 * initialisation du hashmap de fiches, leurs accesseurs et types de données des champs
		 */
		
		for(String currentFiche : Arrays.asList(properties.get("fiches").toString().split(","))){
			for(int i=0; i<dataTypeList.size(); i++){
				if(properties.containsKey(currentFiche+"."+dataTypeList.get(i).getName())){
					Map<String,DataType> map = new HashMap<String,DataType>();
					for(String currentAccessor : Arrays.asList(properties.get(currentFiche+"."+dataTypeList.get(i).getName()).toString().split(",")))
					    map.put(currentAccessor, dataTypeList.get(i));
				    fiches.put(currentFiche, map);
				}
			}
		}
	}
	
	public static ConfigurationReader getInstance(){
		if(instance==null){
			instance = new ConfigurationReader();
		}
		return instance;
	}
	
	public Map<String,Map<String,DataType>> getConfiguration(){
		return fiches;
	}
}