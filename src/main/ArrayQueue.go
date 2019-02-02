package main

import (
	"fmt"
	"strconv"
)

// go  队列的实现[数组学习  基于切片实现的队列]
func main() {
	queue := initQueue(10)
	for a := 0; a < 10 ; a++ {
		enqueue(queue,strconv.Itoa(a))
	}
	for a := 0; a < 12 ; a++ {
		fmt.Println(dequeue(queue))
	}

}

type QueueStruct struct {
	//队列的数组
	items []string
	//队列的大小
	size int
	//队列的头
	head int
	//队列的尾
	tail int
}

//type IQueue interface {
//	initQueue(size int) *QueueStruct
//	enqueue(queueStruct *QueueStruct, item string) bool
//	dequeue(queueStruct *QueueStruct) string
//}

//初始化队列
func initQueue(size int) *QueueStruct {
	return &QueueStruct{*new([]string),size,0,0,}
}

//入队
func enqueue(queueStruct *QueueStruct, item string) bool {
	if len(queueStruct.items) > queueStruct.size {
		return false
	}
	queueStruct.items = append(queueStruct.items, item)
	queueStruct.tail++
	return true
}

//出队
func dequeue(queueStruct *QueueStruct) string  {
	if queueStruct.head == queueStruct.tail {
		return "队列不为，无元素出队"
	}
	str := queueStruct.items[queueStruct.head]
	queueStruct.head++
	return str

}