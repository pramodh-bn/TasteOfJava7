package org.test.pran.groovy

/**
 * Created by pramodh on 3/19/2014.
 */
class Hello {
    static def sayHello = {
        name -> if(name == "Mars" || name == "Ben")
            "Hello author " + name
             else
                "Hello reader " + name + "!"
    }

    public static void main(String[] args) {
        //println(sayHello("Mars"))
        def movieTitles = ["Seven 1", "Snow White 2", "Die Hard 4"]
        //movieTitles.each {println it}
        ("Hazel 1" =~ /(\w+) (\d+)/).each({full, name, age -> println "$name is $age years old."})
        test()
    }
    public static void collectionsTest(String[] args) {
        def abc = ["Java", "Scala", "Clojure"];
        println(abc[0]);
        println(abc.size());
    }
    public static void test() {
        def writer = new StringWriter();
        def xml = new groovy.xml.MarkupBuilder(writer);
        xml.person(id:2){
            name 'Gweneth'
            age 1
        }
        println writer.toString();
    }
}
