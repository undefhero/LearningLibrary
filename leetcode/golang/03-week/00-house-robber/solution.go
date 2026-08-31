package houserobber

// func rob(nums []int) int {
// 	prevOne := 0
// 	prevTwo := 0

// 	for _, money := range nums {
// 		current := max(prevOne, prevTwo+money)

// 		prevTwo = prevOne
// 		prevOne = current
// 	}

// 	return prevOne
// }

func rob(nums []int) int {
	if nums == nil {
		return 0
	}

	res := make([]int, len(nums)+1)
	res[1] = nums[0]

	for i := 2; i < len(nums)+1; i++ {
		res[i] = max(res[i-1], res[i-2]+nums[i-1])
	}

	return res[len(res)-1]
}
