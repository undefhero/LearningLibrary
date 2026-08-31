package maxareaofisland

func maxAreaOfIsland(grid [][]int) int {
	if len(grid) == 0 {
		return 0
	}

	maxArea := 0

	for y := range len(grid) {
		for x := range len(grid[y]) {
			area := calculateArea(grid, y, x)

			if area > maxArea {
				maxArea = area
			}
			// if grid[y][x] == 1 {

			// }
		}
	}

	return maxArea
}

// func calculateArea(grid [][]int, y, x int) int {
// 	stack := [][]int{}
// 	stack = append(stack, []int{y, x})
// 	area := 0

// 	for len(stack) > 0 {
// 		last := len(stack) - 1
// 		cell := stack[last]
// 		stack = stack[:last]

// 		cy, cx := cell[0], cell[1]

// 		if cy >= 0 && cx >= 0 && cy < len(grid) && cx < len(grid[cy]) {
// 			if grid[cy][cx] == 1 {
// 				grid[cy][cx] = 0
// 				area++

// 				stack = append(stack, []int{cy - 1, cx})
// 				stack = append(stack, []int{cy + 1, cx})
// 				stack = append(stack, []int{cy, cx - 1})
// 				stack = append(stack, []int{cy, cx + 1})
// 			}
// 		}
// 	}

// 	return area
// }

func calculateArea(grid [][]int, y, x int) int {
	if y < 0 || x < 0 || y >= len(grid) || x >= len(grid[y]) {
		return 0
	}

	if grid[y][x] == 0 {
		return 0
	}

	grid[y][x] = 0

	return 1 +
		calculateArea(grid, y-1, x) +
		calculateArea(grid, y+1, x) +
		calculateArea(grid, y, x-1) +
		calculateArea(grid, y, x+1)
}
