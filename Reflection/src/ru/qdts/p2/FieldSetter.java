package ru.qdts.p2;
import java.lang.reflect.*;
import ru.qdts.p1.Mystery;

public class FieldSetter {

	private static final String ANALYZED_CLASS_NAME = "ru.qdts.p1.Mystery"; 

	public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, ClassNotFoundException, InvocationTargetException, InstantiationException {
		
		MysteryTester mt = new MysteryTester();
		
		/*
		 * Запуская FieldSetter вы обращаетесь к экземпляру класса MysteryTester, вызывая для него
		 * метод проверки для это задачи testFieldSetter():
		 *
		 */



		/*
		 * Задача 1. У класса Mystery есть приватное поле p1 типа String, для которого не предусмотрено метода setter
		 * Установите значение этого поля: "setByReflection" для созданного с помощью рефлексии экземпляра класса.
		 * Вы можете воспользоваться любым из конструкторов, о которых вы узнали в предыдущей части работы с Mystery.
		 * После установки значения, передайте ваш экземпляр класса в метод testFieldSetter() класса MysteryTest.
		 */
		
		// Здесь должен быть ваш код создания экземпляра и установки значения приватного поля с помощью рефлексии


		Class<?> mc = Class.forName(ANALYZED_CLASS_NAME);

		Mystery mystery = null;

			Constructor<?>[] constructors = mc.getDeclaredConstructors();
			for (Constructor<?> constructor: constructors){
				if (constructor.getParameters().length == 1) {
					mystery = (Mystery)constructor.newInstance(true);
				}
			}

			Field p1Field = mc.getDeclaredField("p1");
			p1Field.setAccessible(true);
			p1Field.set(mystery, "setByReflection");


		mt.testFieldSetter(mystery);

	}

}
