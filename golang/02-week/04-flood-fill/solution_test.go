package floodfill

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func TestFloodFill(t *testing.T) {
	image := [][]int{
		{1, 1, 1},
		{1, 1, 0},
		{1, 0, 1},
	}

	expected := [][]int{
		{2, 2, 2},
		{2, 2, 0},
		{2, 0, 1},
	}

	assert.Equal(t, expected, floodFill(image, 1, 1, 2))
}

func TestFloodFillSameColor(t *testing.T) {
	image := [][]int{
		{0, 0, 0},
		{0, 0, 0},
	}

	expected := [][]int{
		{0, 0, 0},
		{0, 0, 0},
	}

	assert.Equal(t, expected, floodFill(image, 0, 0, 0))
}
