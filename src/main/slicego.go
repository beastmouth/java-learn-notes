package main

import "fmt"

func main() {

	nums := []int{1, 2, 3, 4, 5, 6, 7, 8, 9, 10,}
	sum := 0
	for _, num := range nums   {
		sum += num
	}
	fmt.Println("sum:", sum)
	for i,num := range nums {
		if num == 3 {
			fmt.Println("index:", i)
		}
	}

	//map[string]string   []里面的 string 是键的类型  外面的 string 是值的类型
	kvs := map[string]string{"a": "apple", "b": "banana",}
	var cccMap map[string]string
	cccMap = make(map[string]string)
	cccMap["gl"] = "gl"
	cccMap["hbj"] = "hbj"

	for k,v:=range kvs  {
		fmt.Printf("%s -> %s\n",k, v)
	}

	//range也可以用来枚举Unicode字符串。第一个参数是字符的索引，第二个是字符（Unicode的值）本身
	for i,c := range "go"{
		fmt.Println(i, c)
	}

	//切片
	//长度是	放置了多少个元素
	//容量是	能放置多少个元素
	nums2 := []int{1, 2, 3, 4, 5, 6, 7, 8, 9, 10,}
	slice1 := make([]int, 20)
	fmt.Println("nums2`s length ", len(nums2))
	fmt.Println("slice1`s length ", len(slice1))
	fmt.Println("slice1`s cap ", cap(slice1))
	slice2 := nums2[3:6]
	fmt.Println("slice2`s length ", len(slice2))
	fmt.Println("slice2`s cap ", cap(slice2))


}
