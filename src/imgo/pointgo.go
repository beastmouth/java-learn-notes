package imgo

import "fmt"

func PointGo()  {
	var a = 4
	var b int32
	var c float32
	var ptr *int
	// %T 变量的类型   %x 变量的地址，与%a
	fmt.Printf("第 1 行 - a 变量类型为 = %T\n", a)
	fmt.Printf("第 2 行 - b 变量类型为 = %T\n", b)
	fmt.Printf("第 3 行 - c 变量类型为 = %T\n", c)

	/*  & 和 * 运算符实例 */
	ptr = &a    /* 'ptr' 包含了 'a' 变量的地址 */
	fmt.Printf("a 的值为  %d\n", a)
	fmt.Printf("*ptr 为 %d\n", *ptr)


	fmt.Printf("a 变量的地址为： %x\n",&a)
	fmt.Printf("ptr 变量的指针地址为：%d\n",ptr)


	var ptr2 *int
	fmt.Printf("prt2 的值为 ： %x\n", ptr2)
	if ptr2 == nil {
		fmt.Printf("prt2 为 nil\n")
	}
	if ptr2 != nil {
		fmt.Printf("prt2 不为 nil\n")
	}
}
