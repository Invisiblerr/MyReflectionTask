package ru.qdts.p2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import ru.qdts.p1.Mystery;

public class MethodInvoker {

	private static final String ANALYZED_CLASS_NAME = "ru.qdts.p1.Mystery";

	public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {

		MysteryTester mt = new MysteryTester();

		/*
		 * Задача 2. Обращаясь к классу MysteryTester с помощью метода getCollection вы получаете от него коллекцию
		 * элементов, каждый из которых является наследником Mystery. Вы не знаете детали интерфейса каждого из этих наследников,
		 * но знаете, что у них есть метод, в названии которого есть слова "get" и "Info". Он возвращает String.
		 * Вам нужно вызвать эти методы для каждого элемента в коллекции. Полученные строки "склеить", добавив после
		 * каждого из возвращаемых значений ", ". В конце строки этих символов быть не должно.
		 * То есть, должна получиться строка вида "Info1, Info2, Info3", где
		 * Info1 - строка, которую возщвращает искомый метод для первого элемента коллекции
		 * Info2 - для второго
		 * ...
		 * Передайте полученную строку в метод testMethodInvoker класса MysteryTester
		 */

		ArrayList<Mystery> list = mt.getCollection();
		String resultString = "";

		// Здесь должен быть ваш код вызова информационных методов и получения итогового сообщения
		for (Mystery mystery : list) {
			Class<?> mysteryClass = mystery.getClass();
			Method[] methods = mysteryClass.getDeclaredMethods();
			for (Method method : methods) {
				if (method.getName().contains("get") && method.getName().contains("Info")) {
					resultString += (String) method.invoke(mystery, (Object) new Class[]{}) + ", ";
				}
			}

			if (resultString.endsWith(", ")) {
				resultString = resultString.substring(0, resultString.length() - 2);
			}

			/*for (Mystery mystery : list) {
				Class mysteryClass = mystery.getClass();
				Method[] methods = mysteryClass.getDeclaredMethods();
				for (Method method : methods) {
					if (method.getName().contains("get") && method.getName().contains("Info")) {
						resultString += (String) method.invoke(mystery, new Class[]{}) + ", ";
					}
				}
			}
			if (resultString.endsWith(", ")) {
				resultString = resultString.substring(0, resultString.length() - 2);
			}*/

			mt.testMethodInvoker(resultString);

		}
	}
}




