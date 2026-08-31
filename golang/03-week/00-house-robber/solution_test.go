package houserobber

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func TestRobFourHouses(t *testing.T) {
	nums := []int{1, 2, 3, 1}

	assert.Equal(t, 4, rob(nums))
}

func TestRobFiveHouses(t *testing.T) {
	nums := []int{2, 7, 9, 3, 1}

	assert.Equal(t, 12, rob(nums))
}
