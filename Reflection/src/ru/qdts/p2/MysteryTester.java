package ru.qdts.p2;

import java.util.ArrayList;
import ru.qdts.p1.*;
import java.lang.reflect.*;

public class MysteryTester {

	private static final String ANALYZED_CLASS_NAME = "ru.qdts.p1.Mystery";
	private static final int MAX_INT = Integer.MAX_VALUE;
	@SuppressWarnings("rawtypes")
	private Class mysteryClass;
	
	public MysteryTester() {
		super();
		try {
			mysteryClass = Class.forName(ANALYZED_CLASS_NAME);
		}
		catch(ClassNotFoundException ex) {
			System.out.println("Класс Mystery не был загружен в память JVM!");
		}
	}

	public void checkResult() {
		
		System.out.println("Вы не смогли правильно ответить на все вопросы!");
	}
	
	/*
	 * ВОПРОС 1. Сколько всего полей у класса Mystery?
	 * Ответ передайте в метод question1 класса MysteryTester в виде аргумента типа int
	 */
	public void question1(int i) {
		System.out.println("ВОПРОС 1. Сколько всего полей у класса Mystery?");
		System.out.println("Ответ: " + String.valueOf(i));
		
		int fieldsNumber = mysteryClass.getDeclaredFields().length;
		
		if (fieldsNumber == i) {
			System.out.println("Это правильный ответ!");
		}
		else {
			System.out.println("Это НЕПРАВИЛЬНЫЙ ответ!");
		}
		System.out.println();	
	}

	/*
	 * ВОПРОС 2. Сколько из этих полей - публичные?
	 * Ответ передайте в метод question2 класса MysteryTester в виде аргумента типа int
	 */
	public void question2(int i) {
		System.out.println("ВОПРОС 2. Сколько из этих полей - публичные?");
		System.out.println("Ответ: " + String.valueOf(i));
		
		int fieldsNumber = mysteryClass.getFields().length;
		
		if (fieldsNumber == i) {
			System.out.println("Это правильный ответ!");
		}
		else {
			System.out.println("Это НЕПРАВИЛЬНЫЙ ответ!");
		}
		System.out.println();
		
	}

	/*
	 * ВОПРОС 3. А сколько из этих полей - защищенные (protected)?
	 * Ответ передайте в метод question3 класса MysteryTester в виде аргумента типа int
	 */
	public void question3(int i) {
		System.out.println("ВОПРОС 3. А сколько из этих полей - защищенные (protected)?");
		System.out.println("Ответ: " + String.valueOf(i));
		
		int protectedFieldsNumber = 0;
		Field[] fields = mysteryClass.getDeclaredFields();
		for (Field field: fields) {
			int mods = field.getModifiers();
			if (Modifier.isProtected(mods)){
				protectedFieldsNumber++;
			}
		}
		
		
		if (protectedFieldsNumber == i) {
			System.out.println("Это правильный ответ!");
		}
		else {
			System.out.println("Это НЕПРАВИЛЬНЫЙ ответ!");
		}
		System.out.println();
		
	}

	/*
	 * ВОПРОС 4. В классе должно быть поле, имя которого начинается c "bohemian", укажите его имя и модификатор (private, protected или public)?
	 * Ответ передайте в метод question4 класса MysteryTester в виде аргументов типа String
	 */
	public void question4(String name, String modificator) {
		System.out.println("ВОПРОС 4. В классе должно быть поле, имя которого начинается c \"bohemian\", укажите его имя и модификатор (private, protected или public)?");
		System.out.println("Ответ: " + name + ", " + modificator);
		
		Field[] fields = mysteryClass.getFields();
		String fieldName = "";
		String fieldMod = "default";
		for (Field field: fields) {
			if (field.getName().contains("bohemian")) {
				fieldName = field.getName();
				int mods = field.getModifiers();
				if (Modifier.isPublic(mods)){
					fieldMod = "public";
				}
				else if (Modifier.isProtected(mods)){
					fieldMod = "protected";
				}
				else if (Modifier.isPrivate(mods)){
					fieldMod = "private";
				}
			}
		}
		
		
		if (name.equalsIgnoreCase(fieldName) && modificator.equalsIgnoreCase(fieldMod)) {
			System.out.println("Это правильный ответ!");
		}
		else {
			System.out.println("Это НЕПРАВИЛЬНЫЙ ответ!");
		}
		System.out.println();
		
	}

	/*
	 * ВОПРОС 5. А какой тип у поля из предыдущего вопроса?
	 * Ответ передайте в метод question5 класса MysteryTester в виде аргумента типа String
	 */
	public void question5(String string) {
		System.out.println("ВОПРОС 5. А какой тип у поля из предыдущего вопроса?");
		System.out.println("Ответ: " + string);
		
		Field[] fields = mysteryClass.getFields();
		Class fieldType = null;
		for (Field field: fields) {
			if (field.getName().contains("bohemian")) {
				fieldType = field.getType();
			}
		}
		
		
		if (string.equalsIgnoreCase(fieldType.getSimpleName())) {
			System.out.println("Это правильный ответ!");
		}
		else {
			System.out.println("Это НЕПРАВИЛЬНЫЙ ответ!");
		}
		System.out.println();
		
	}

	/*
	 * ВОПРОС 6. А есть ли у нашего класса статическое поле, с именем начинающимся на baker? Если есть - укажите его имя, если нет - укажите "no"
	 * Ответ передайте в метод question6 класса MysteryTester в виде аргумента типа String
	 */
	public void question6(String string) {
		System.out.println("ВОПРОС 6. А есть ли у нашего класса статическое поле, с именем начинающимся на baker? Если есть - укажите его имя, если нет - укажите \"no\"");
		System.out.println("Ответ: " + string);
		
		Field[] fields = mysteryClass.getFields();
		String fieldName = "no";
		for (Field field: fields) {
			if (field.getName().contains("baker")) {
				int mods = field.getModifiers();
				if (Modifier.isStatic(mods)){
					fieldName = field.getName();
					break;
				}
				
			}
		}
		
		
		if (string.equalsIgnoreCase(fieldName)) {
			System.out.println("Это правильный ответ!");
		}
		else {
			System.out.println("Это НЕПРАВИЛЬНЫЙ ответ!");
		}
		System.out.println();
		
	}

	/*
	 * ВОПРОС 7. Сколько всего конструкторов у нашего класса?
	 * Ответ передайте в метод question7 класса MysteryTester в виде аргумента типа int
	 */
	public void question7(int i) {
		System.out.println("ВОПРОС 7. Сколько всего конструкторов у нашего класса?");
		System.out.println("Ответ: " + String.valueOf(i));
		
		int constructorNumber = mysteryClass.getDeclaredConstructors().length;
		
		if (constructorNumber == i) {
			System.out.println("Это правильный ответ!");
		}
		else {
			System.out.println("Это НЕПРАВИЛЬНЫЙ ответ!");
		}
		System.out.println();	
	}

	/*
	 * ВОПРОС 8. Сколько аргументов, принимают конструкторы с минимальным и максимальным количеством аргументов?
	 * Ответ передайте в метод question8 класса MysteryTester в виде аргументов типа int
	 */
	public void question8(int min, int max) {
		System.out.println("ВОПРОС 8. Сколько аргументов, принимают конструкторы с минимальным и максимальным количеством аргументов?");
		System.out.println("Ответ: " + String.valueOf(min) + ", " + String.valueOf(max));
		
		Constructor[] constructors = mysteryClass.getDeclaredConstructors();
		int maxArgs = -1;
		int minArgs = MAX_INT;
		
		for (Constructor constructor: constructors) {
			int args = constructor.getParameterCount();
			if (args < minArgs) {
				minArgs = args;
			}
			if (args > maxArgs) {
				maxArgs = args;
			}
		}
		
		if (maxArgs == max && minArgs == min) {
			System.out.println("Это правильный ответ!");
		}
		else {
			System.out.println("Это НЕПРАВИЛЬНЫЙ ответ!");
		}
		System.out.println();
		
	}

	/*
	 * ВОПРОС 9. Каковы типы аргументов у конструктора с максимальным количеством аргументов?
	 * Ответ передайте в метод question9 класса MysteryTester в виде аргумента типа String вида "String,int,float,String" (показан пример)
	 */
	public void question9(String string) {
		System.out.println("ВОПРОС 9. Каковы типы аргументов у конструктора с максимальным количеством аргументов?");
		System.out.println("Ответ: " + string);
		
		Constructor[] constructors = mysteryClass.getDeclaredConstructors();
		int maxArgs = -1;
		String argTypes = "";
		
		for (Constructor constructor: constructors) {
			int args = constructor.getParameterCount();
			if (args > maxArgs) {
				maxArgs = args;
				Parameter[] params = constructor.getParameters();
				for (Parameter param: params) {
					argTypes = argTypes.concat(param.getType().getSimpleName() + ",");
				}
			}
		}
		if (argTypes.endsWith(",")) {
			argTypes = argTypes.substring(0, argTypes.length() - 1);
		}
		//System.out.println(argTypes);
		if (argTypes.equals(string)) {
			System.out.println("Это правильный ответ!");
		}
		else {
			System.out.println("Это НЕПРАВИЛЬНЫЙ ответ!");
		}
		System.out.println();
		
	}

	/*
	 * ВОПРОС 10. Создайте экземпляр класса Mystery с использованием конструктора с максимальным количеством аргументов. 
	 * Вам нужно выбрать правильные значения для аргументов. Какие? Возможно, вам помогут значения статических полей, которые есть у класса. 
	 * Ответ передайте в метод question10 класса MysteryTester в виде аргумента типа Mystery
	 */
	public void question10(Mystery mystery) {
		/*
		 * Для начала посмотрим на статические поля
		 * Field[] fields = mysteryClass.getFields();
		 * 
		 * for (Field field: fields) {
		 *		int mods = field.getModifiers();
		 *		if (Modifier.isStatic(mods)){
		 *			System.out.println(field.getName());
		 *			System.out.println(field.get());
		 *		}
				
		 *}
		 * Понимаем, что нам нужны поля CONSTRUCTOR_ARG1, CONSTRUCTOR_ARG2, CONSTRUCTOR_ARG3
		 */
		
		System.out.println("ВОПРОС 10. Создайте экземпляр класса Mystery с использованием конструктора с максимальным количеством аргументов.");
		System.out.println("Ответ: " + "******");
		
		Constructor[] constructors = mysteryClass.getDeclaredConstructors();
		Constructor maxConstructor = null;
		int maxArgs = -1;
		
		for (Constructor constructor: constructors) {
			int args = constructor.getParameterCount();
			if (args > maxArgs) {
				maxArgs = args;
				maxConstructor = constructor;
			}
		}
		Mystery newInst = null;
		try {
			newInst = (Mystery) maxConstructor.newInstance("ololo", 123, 678.9f);
		}
		catch(Exception ex) {
			System.out.println("Could not create instance");
		}
		try {
			if (newInst.getP1().equals(mystery.getP1()) && newInst.getP2() == mystery.getP2()) {
				System.out.println("Это правильный ответ!");
			}
			else {
				System.out.println("Это НЕПРАВИЛЬНЫЙ ответ!");
			}
		}
		catch(Exception ex) {
			System.out.println("Это НЕПРАВИЛЬНЫЙ ответ!");
		}
		
		System.out.println();
		
	}
		

	/*
	 * ВОПРОС 11. Сколько всего методов у класса? Сколько из них - статические? 
	 * Ответ передайте в метод question11 класса MysteryTester в виде аргументов типа int
	 */
	public void question11(int i, int j) {
		System.out.println("ВОПРОС 11. Сколько всего методов у класса? Сколько из них - статические? ");
		System.out.println("Ответ: " + String.valueOf(i) + ", " + String.valueOf(j));
		
		Method[] methods = mysteryClass.getDeclaredMethods();
		int methodNumber = methods.length;
		int staticMethodNumber = 0;
		for (Method method: methods) {
				int mods = method.getModifiers();
				if (Modifier.isStatic(mods)){
					staticMethodNumber++;
				}			
		}
		if (methodNumber == i && staticMethodNumber == j) {
			System.out.println("Это правильный ответ!");
		}
		else {
			System.out.println("Это НЕПРАВИЛЬНЫЙ ответ!");
		}
		System.out.println();
		
	}

	/*
	 * ВОПРОС 12. А сколько всего методов getter? Таковыми можно считать те, имена которых начинаются с "get" или "is"
	 * Ответ передайте в метод question12 класса MysteryTester в виде аргумента типа int
	 */
	public void question12(int i) {
		System.out.println("ВОПРОС 12. А сколько всего методов getter? Таковыми можно считать те, имена которых начинаются с \"get\" или \"is\"");
		System.out.println("Ответ: " + String.valueOf(i));
		
		Method[] methods = mysteryClass.getDeclaredMethods();
		int getterNumber = 0;
		for (Method method: methods) {
				if (method.getName().startsWith("get") || method.getName().startsWith("is")){
					getterNumber++;
				}			
		}
		if (getterNumber == i) {
			System.out.println("Это правильный ответ!");
		}
		else {
			System.out.println("Это НЕПРАВИЛЬНЫЙ ответ!");
		}
		System.out.println();
		
	}
	
	/*
	 * ВОПРОС 13. Для какого приватного поля класса нет метода setter (метод с именем set<Имя_поля>)?
	 * Ответ передайте в метод question13 класса MysteryTester в виде аргумента типа String
	 */
	public void question13(String string) {
		System.out.println("ВОПРОС 13. Для какого приватного поля класса нет метода setter (метод с именем set<Имя_поля>)?");
		System.out.println("Ответ: " + string);
		
		Field[] fields = mysteryClass.getDeclaredFields();
		String fieldWithoutSetter = "";
		for (Field field: fields) {
			if (Modifier.isPrivate(field.getModifiers())) {
				String fieldName = field.getName();
				String setterName = "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
				try {
					Method method = mysteryClass.getMethod(setterName, new Class[] {field.getType()});
				}
				catch (NoSuchMethodException ex) {
					fieldWithoutSetter = fieldName;
				}
			}
		}
		System.out.println(fieldWithoutSetter);
		if (fieldWithoutSetter.equalsIgnoreCase(string)) {
			System.out.println("Это правильный ответ!");
		}
		else {
			System.out.println("Это НЕПРАВИЛЬНЫЙ ответ!");
		}
		System.out.println();
		
	}

	/*
	 * ВОПРОС 14. У класса есть метод со словом solve в названии. Какое у него имя?
	 * Ответ передайте в метод question14 класса MysteryTester в виде аргумента типа String
	 */
	public void question14(String string) {
		System.out.println("ВОПРОС 14. У класса есть метод со словом solve в названии. Какое у него имя?");
		System.out.println("Ответ: " + string);
		
		String solveMethod = "";
		Method[] methods = mysteryClass.getDeclaredMethods();
		for (Method method: methods) {
			String methodName = method.getName();
			if (methodName.contains("solve")) {
				solveMethod = methodName;
				break;
			}
		}
		if (solveMethod.equalsIgnoreCase(string)) {
			System.out.println("Это правильный ответ!");
		}
		else {
			System.out.println("Это НЕПРАВИЛЬНЫЙ ответ!");
		}
		System.out.println();
		
	}

	/*
	 * ВОПРОС 15. Перечислите типы аргументов для метода из прошлого вопроса.
	 * Ответ передайте в метод question15 класса MysteryTester в виде аргумента типа String вида "String,int,float,String" (показан пример)
	 */
	public void question15(String string) {
		System.out.println("ВОПРОС 15. Перечислите типы аргументов для метода из прошлого вопроса.");
		System.out.println("Ответ: " + string);
		
		String solveMethod = "";
		String solveMethodArgs = "";
		Method[] methods = mysteryClass.getDeclaredMethods();
		for (Method method: methods) {
			String methodName = method.getName();
			if (methodName.contains("solve")) {
				solveMethod = methodName;
				Parameter[] params = method.getParameters();
				for (Parameter param: params) {
					solveMethodArgs = solveMethodArgs.concat(param.getType().getSimpleName() + ",");
				}
				break;
			}
		}
		if (solveMethodArgs.endsWith(",")) {
			solveMethodArgs = solveMethodArgs.substring(0, solveMethodArgs.length() - 1);
		}				
		if (solveMethodArgs.equalsIgnoreCase(string)) {
			System.out.println("Это правильный ответ!");
		}
		else {
			System.out.println("Это НЕПРАВИЛЬНЫЙ ответ!");
		}
		System.out.println();
		
	}
	
	/*
	 * ВОПРОС 16. Какой тип возвращает метод из предыдущих вопросов?
	 * Ответ передайте в метод question16 класса MysteryTester в виде аргумента типа String
	 */
	public void question16(String string) {
		System.out.println("ВОПРОС 16. Какой тип возвращает метод из предыдущих вопросов?");
		System.out.println("Ответ: " + string);
		
		String solveMethod = "";
		String resultClassName = "";
		Method[] methods = mysteryClass.getDeclaredMethods();
		for (Method method: methods) {
			String methodName = method.getName();
			if (methodName.contains("solve")) {
				solveMethod = methodName;
				Class resultClass = method.getReturnType();
				resultClassName = resultClass.getSimpleName();
			}
		}
				
		if (resultClassName.equalsIgnoreCase(string)) {
			System.out.println("Это правильный ответ!");
		}
		else {
			System.out.println("Это НЕПРАВИЛЬНЫЙ ответ!");
		}
		System.out.println();
		
	}

	/*
	 * ВОПРОС 17. Вызовите метод из двух предыдущих вопросов с ответом на главный вопрос вселенной в качестве аргумента.
	 * Ответ можно поискать в статических полях
	 */
	public void question17() {
		// NO SOLUTION!!!! Mua-ha-ha-ha-ha
		System.out.println("ВОПРОС 17. Вызовите метод из двух предыдущих вопросов с ответом на главный вопрос вселенной в качестве аргумента.");
		System.out.println("Ответ: " + "********");
		
		int testValue;
		
		if (Mystery.solved == Mystery.mainQuestionAnswer) {
			System.out.println("Это правильный ответ!");
		}
		else {
			System.out.println("Это НЕПРАВИЛЬНЫЙ ответ!");
		}
		System.out.println();
	}

	public void testFieldSetter(Object obj) {
		System.out.println("Задача 1. Установите значение поля p1 - \"setByReflection\" с помощью рефлексии.");
		Mystery mystery = null;
		
		/*
		КОД РЕШЕНИЯ: 

		Class mysteryClass = null;
		try {
			mysteryClass = Class.forName(ANALYZED_CLASS_NAME);
		}
		catch(ClassNotFoundException ex) {
			System.out.println("Класс Mystery не был загружен в память JVM!");
			return;
		}
		
		Mystery mystery = null;
		try {
			Constructor[] constructors = mysteryClass.getDeclaredConstructors();
			for (Constructor constructor: constructors){
				if (constructor.getParameters().length == 1) {
					mystery = (Mystery)constructor.newInstance(true);
				}
			}
			
			Field p1Field = mysteryClass.getDeclaredField("p1");
			p1Field.setAccessible(true);
			p1Field.set(mystery, "setByReflection");
		}
		catch(Exception ex) {
			System.out.println("Ошибка при создании экземпляра или при работе с полем.");
			return;
		}
		 
		 
		 */
		
		try {
			mystery = (Mystery)obj;
		}
		catch(Exception ex) {
			System.out.println("В метод testFieldSetter был передан НЕ экземпляр класса Mystery");
		}
		
		if (mystery.getP1().equals("setByReflection")) {
			System.out.println("Это правильное решение!");
		}
		else {
			System.out.println("Это НЕПРАВИЛЬНОЕ решение!");
		}
		System.out.println();
		
	}

	public void testMethodInvoker(String string) {
		
		/*
		КОД РЕШЕНИЯ: 
		try {
			for (Mystery mystery: list) {
				Class mysteryClass = mystery.getClass();
				Method[] methods = mysteryClass.getDeclaredMethods();
				for (Method method: methods) {
					if(method.getName().contains("get") && method.getName().contains("Info")) {
						resultString += (String)method.invoke(mystery, new Class[] {}) + ", ";
					}
				}
			}
			if (resultString.endsWith(", ")) {
				resultString = resultString.substring(0, resultString.length() - 2);
			}
		}
		catch(Exception ex) {
			
		}
		*/
		
		System.out.println("Задача 2. Вызовите информационные методы для каждого экземпляра коллекции Mystery элементов");
		if (string.equals("Info about Puzzle, Info about Problem")) {
			System.out.println("Это правильное решение!");
		}
		else {
			System.out.println("Это НЕПРАВИЛЬНОЕ решение!");
		}
		System.out.println();
		
	}
	
	public ArrayList<Mystery> getCollection(){
		ArrayList<Mystery> result = new ArrayList<Mystery>();
		Mystery el1 = new Puzzle(true);
		Mystery el2 = new Problem(true);
		result.add(el1);
		result.add(el2);
		return result;

	}
	
}
