package main

import "fmt"

func main() {
	strs := []string{"1", "2", "3", "4", "4", "3", "2", "1",}
	node := initLinkList(strs)
	midNode := findMidNode(node)
	if midNode == nil {
		fmt.Printf("mid node is not present \n")
	} else{
		fmt.Printf("mid node is %s\n",midNode.data)
	}
	if midNode != nil {
		//reversalMidNodeLink := reversalLinkList(midNode)
		//printLinkList(reversalMidNodeLink)
		checkIsPalinadrome(node, midNode)
	}
	checkIsRing(node)


}

type Node struct {
	data string
	next *Node
}

//初始化链表 仅针对无环链表
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

//发现链表的中间节点 仅针对无环链表
func findMidNode(head *Node) *Node {
	if head == nil {
		return nil
	}
	oneStep := head
	twoStep := head
	for  {
		if twoStep.next == nil {
			break
		}
		if twoStep.next.next == nil {
			oneStep = oneStep.next
			break
		}
		oneStep = oneStep.next
		twoStep = twoStep.next.next
	}
	return oneStep
}

//反转链表 仅针对无环链表
func reversalLinkList(node *Node) *Node {
	if node == nil {
		 return nil
	}
	if node.next == nil {
		return node
	}

	headNode := node
	tempNode := node
	for {
		if node.next == nil {
			break
		}
		tempNode = node.next
		node.next = node.next.next
		tempNode.next = headNode
		headNode = tempNode
	}
	return headNode
}

//打印链表 仅针对无环链表
func printLinkList(node *Node)  {
	var needPrint string
	for  {
		if node == nil {
			break
		}
		needPrint = needPrint + node.data + " "
		node = node.next
	}
	fmt.Printf("链表为：%s\n", needPrint)
}

//校验链表是否为回文链表 仅针对无环链表
func checkIsPalinadrome(headNode *Node, midNode *Node)  {
	if headNode.next == nil {
		fmt.Printf("只有一个元素 不是回文链表\n")
		return
	}
	node := reversalLinkList(midNode)
	flag := true
	for {
		if headNode == midNode {
			break
		}
		if node.data != headNode.data {
			flag = false
		}
		headNode = headNode.next
		node = node.next
	}
	if flag {
		fmt.Printf("传入的链表是回文链表\n")
	} else {
		fmt.Printf("传入的链表不是回文链表\n")
	}
}

//校验传入的链表是否成环
func checkIsRing(node *Node) {
	if node == nil || node.next == nil {
		 fmt.Printf("链表不存在，无需校验链表是否成环\n")
		return
	}

	oneStep := node
	twoStep := node
	for {
		if twoStep.next == nil {
			fmt.Printf("链表不存在环\n")
			break
		}
		if twoStep.next.next == nil {
			fmt.Printf("链表不存在环\n")
			break
		}
		oneStep = oneStep.next
		twoStep = twoStep.next.next
		if oneStep == twoStep {
			fmt.Printf("链表存在环\n")
			break
		}
	}
}