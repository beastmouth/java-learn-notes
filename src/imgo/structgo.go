package imgo

type Person struct {
	name string
	age int
	sex string
}

func SetPersonInfo(name string ,age int ,sex string) (Person)  {
	person := Person{name, age, sex,}
	return person
}