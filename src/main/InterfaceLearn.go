package main

// go 没有继承
import "fmt"

type Animal interface {
	Speak() string
}

type Dog struct {

}

func (d Dog) Speak() string {
	return "Wang wang wang !"
}

type Cat struct {

}

func (c Cat) Speak() string {
	return "Miao miao miao !"
}


type JavaProgrammer struct {

}

func (programmer JavaProgrammer) Speak() string {
	return "Hello world !"
}

func main() {
	animals := []Animal{Dog{},Cat{},JavaProgrammer{}}
	for _, animal := range animals{
		fmt.Println(animal.Speak())
	}
}