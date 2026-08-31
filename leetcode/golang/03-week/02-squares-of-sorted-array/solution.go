package squaresofsortedarray

func sortedSquares(nums []int) []int {
	if len(nums) == 0 {
		return nums
	}

	sorted := make([]int, len(nums))

	left, right, pointer := 0, len(nums)-1, len(nums)-1

	for left <= right {
		leftSq := nums[left] * nums[left]
		rightSq := nums[right] * nums[right]

		if leftSq >= rightSq {
			sorted[pointer] = leftSq
			left++
		} else {
			sorted[pointer] = rightSq
			right--
		}

		pointer--
	}

	return sorted
}
