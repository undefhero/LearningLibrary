package floodfill

func floodFill(image [][]int, sr int, sc int, color int) [][]int {
	if len(image) == 0 {
		return [][]int{}
	}

	startColor := image[sr][sc]
	if startColor == color {
		return image
	}

	stack := [][]int{}
	stack = append(stack, []int{sr, sc})

	for len(stack) > 0 {
		last := len(stack) - 1
		cell := stack[last]
		stack = stack[:last]

		cr, cc := cell[0], cell[1]

		if cr >= 0 && cc >= 0 && cr < len(image) && cc < len(image[0]) {
			if image[cr][cc] == startColor {
				image[cr][cc] = color

				stack = append(stack, []int{cr - 1, cc})
				stack = append(stack, []int{cr, cc - 1})
				stack = append(stack, []int{cr + 1, cc})
				stack = append(stack, []int{cr, cc + 1})
			}
		}
	}

	return image
}
