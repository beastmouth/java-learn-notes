package sort

func BubbleSort(numbers []int) []int {
	length := len(numbers)
	for i := 0; i < length; i++ {
		for j := 1; j < length - i; j++ {
			if numbers[j-1] > numbers[j] {
				temp := numbers[j-1]
				numbers[j-1] = numbers[j]
				numbers[j] = temp
			}
		}
	}
	return numbers
}