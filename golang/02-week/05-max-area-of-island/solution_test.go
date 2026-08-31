package maxareaofisland

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func TestMaxAreaOfIsland(t *testing.T) {
	grid := [][]int{
		{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
		{0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
		{0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
		{0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
		{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
		{0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
		{0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
	}

	assert.Equal(t, 6, maxAreaOfIsland(grid))
}

func TestMaxAreaOfIslandNoLand(t *testing.T) {
	grid := [][]int{
		{0, 0, 0, 0, 0, 0, 0, 0},
	}

	assert.Equal(t, 0, maxAreaOfIsland(grid))
}

func TestMaxAreaOfIslandSingleLandCell(t *testing.T) {
	grid := [][]int{{1}}

	assert.Equal(t, 1, maxAreaOfIsland(grid))
}
