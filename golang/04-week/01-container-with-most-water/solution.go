package containerwithmostwater

func maxArea(height []int) int {
	if len(height) <= 1 {
		return 0
	}

	left, right := 0, len(height)-1
	area := 0

	for left < right {
		currentArea := min(height[left], height[right]) * (right - left)
		area = max(area, currentArea)

		if height[left] > height[right] {
			right--
		} else {
			left++
		}
	}

	return area
}
