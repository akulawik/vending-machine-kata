package spockintro.commons

import spock.lang.Specification

class ListSpockTest extends Specification {

    def "should add all items from one list to another" ()
    {
        given:
            def baseList = ["one", "two"]
            def addMe = ["three", "four"]

        when:
            baseList.addAll addMe

        then:
            baseList == ["one", "two", "three", "four"]
    }
}
