package main

import "fmt"

func main() {
	strs := []string{"1", "2", "3", "4", "3", "2", "1",}
	node := initLinkList(strs)
	fmt.Println(node.data)
}

type Node struct {
	data string
	next *Node
}

func initLinkList(strs []string) *Node {
	var nodeHead *Node
	var nodeCurr *Node
	for _,str := range strs {
		if nodeHead == nil {
			//& 指针变量的存储地址
			nodeHead = &Node{str, nil,}
			nodeCurr = nodeHead
		} else {
			nodeCurr.next = &Node{str, nil,}
			nodeCurr = nodeCurr.next
		}
	}
	return nodeHead
}