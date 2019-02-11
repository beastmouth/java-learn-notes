package main

import (
	"fmt"
	"github.com/BeastMouth/java-learn-notes/src/imgo/sort"
)

func main()  {
	numbers := []int{1, 2, 44, 32, 6, 12, 456, 2}
	numbers = sort.BubbleSort(numbers)
	for _, number := range numbers {
		fmt.Printf("%d ",number)
	}
}
