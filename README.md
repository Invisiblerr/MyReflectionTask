# Exercise6
Использование рефлексии

#Для запуска проекта скопируйте указанный ниже код
#Вставьте с ПОЛНОЙ заменой в файл tasks.json
#Расположение файла tasks.json: Explorer => первая папка ".theia" => tasks.json

# Запуск c пакетами ( успешно )

{
    "tasks": [
        {
            "type": "che",
            "label": "Sherlock build and run",
            "command": "javac -d /projects/Lab6/Reflection/bin -sourcepath /projects/Lab6/Reflection/src /projects/Lab6/Reflection/src/ru/qdts/p2/Sherlock.java && java -classpath /projects/Lab6/Reflection/bin ru.qdts.p2.Sherlock",
            "target": {
                "workingDir": "${CHE_PROJECTS_ROOT}/Lab6/Reflection/src",
                "component": "maven"
            }
        },
        {
            "type": "che",
            "label": "MethodInvoker build and run",
            "command": "javac -d /projects/Lab6/Reflection/bin -sourcepath /projects/Lab6/Reflection/src /projects/Lab6/Reflection/src/ru/qdts/p2/MethodInvoker.java && java -classpath /projects/Lab6/Reflection/bin ru.qdts.p2.MethodInvoker",
            "target": {
                "workingDir": "${CHE_PROJECTS_ROOT}/Lab6/Reflection/src",
                "component": "maven"
            }
        },
         {
            "type": "che",
            "label": "FieldSetter build and run",
            "command": "javac -d /projects/Lab6/Reflection/bin -sourcepath /projects/Lab6/Reflection/src /projects/Lab6/Reflection/src/ru/qdts/p2/FieldSetter.java && java -classpath /projects/Lab6/Reflection/bin ru.qdts.p2.FieldSetter",
            "target": {
                "workingDir": "${CHE_PROJECTS_ROOT}/Lab6/Reflection/src",
                "component": "maven"
            }
        },
        {
            "type": "che",
            "label": "MysteryTester build and run",
            "command": "javac -d /projects/Lab6/Reflection/bin -sourcepath /projects/Lab6/Reflection/src /projects/Lab6/Reflection/src/ru/qdts/p2/MysteryTester.java && java -classpath /projects/Lab6/Reflection/bin ru.qdts.p2.MysteryTester",
            "target": {
                "workingDir": "${CHE_PROJECTS_ROOT}/Lab6/Reflection/src",
                "component": "maven"
            }
        }
    ]
}
