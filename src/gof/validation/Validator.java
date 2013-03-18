package gof.validation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Validator { 
	
	private Map<String,Map<String,DataType>> fiches;
	
	public Validator(){
		fiches = ConfigurationReader.getInstance().getConfiguration();		
	}
	
	@SuppressWarnings("unchecked")
	public <T> Map<String,ValidatorLine> validateFiche(Object fiche, Class<T> classe) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		
		Map<String, ValidatorLine> validationMap = new HashMap<String, ValidatorLine>();
		Map<String, DataType> ficheItems = new HashMap<String, DataType>();
		
		System.out.println("Fiche : "+classe.getCanonicalName());
		
		ficheItems = fiches.get(classe.getCanonicalName());
		fiche = (T)fiche;
		
		List<Method> ficheMethodList = Arrays.asList(classe.getDeclaredMethods());
		
		for(int i=0; i<ficheMethodList.size(); i++){
			DataType dataType = ficheItems.get(ficheMethodList.get(i).getName());
			if(dataType!=null){
				String result = ficheMethodList.get(i).invoke(fiche, (Object[]) null).toString();
				boolean state = result.matches(dataType.getExpression());
				ValidatorLine validatorLine = new ValidatorLine();
				validatorLine.setDescription(dataType.getDescription());
				validatorLine.setExample(dataType.getExample());
				validatorLine.setState(state);
				validationMap.put(ficheMethodList.get(i).getName(), validatorLine);
				System.out.println("Method: "+ficheMethodList.get(i).getName()+" Valid : "+state);
			}
		}
		return validationMap;
	}	
}