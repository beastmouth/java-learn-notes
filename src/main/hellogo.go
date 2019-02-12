package main

import (
	"flag"
	"fmt"

	//"github.com/BeastMouth/java-learn-notes/src/imgo"
)

const (
	aaa = "aaa"
	bbb = "bbb"
)

const (
	aa = iota		//0
	bb = 2
	cc				//2
	dd = 100
	ee				//100
	ff = "aaa"
	gg				//aaa
	hh = iota		//不是1   是7   iota 是用来记录const的行索引的 即 第几行
	ii				//不是2	  是8
)

const (
	a = 1 << iota
	b = 3 << iota	//6
	c				//6错	3<<2
	d				//6错	3<<3
)

func swap (x , y string)  {
	var temp string
	temp = x
	x = y
	y = temp
}

func swapReturn (x,y string) (string,string) {
	return y, x
}

func main ()  {
	//fmt.Println("Hello world!")
	//imgo.HelloGo()
	//var age int
	//age = 23
	//fmt.Printf("my age is %d \n",age)
	//
	////const 常量 不再被修改的量
	//const gl string  = "gl"
	//fmt.Println(gl)
	//
	////println 打印的位置是不固定的 类似于开了多线程打印一样
	////要保证顺序  fmt.Println
	//println(aaa,bbb)
	//fmt.Println(aaa, bbb)
	//fmt.Println(aa,bb,cc,dd,ee,ff,gg,hh,ii)
	//fmt.Println(a,b,c,d)
	//
	//var str1 = "str1"
	//var str2 = "str2"
	//swap(str1, str2)
	//fmt.Println(str1, str2)
	//
	//// := 声明并赋值  声明的变量不能再之前声明过
	//str3, str4 := swapReturn(str1, str2)
	//fmt.Println(str3,str4)
	//
	//imgo.PointGo()
	//
	//hbj := imgo.SetPersonInfo("hbj",23, "男")
	//fmt.Println(hbj)

	var name string
	flag.StringVar(&name, "name", "everyone", "The greeting object.")
	fmt.Printf("Hello, %v \n", name)

}
