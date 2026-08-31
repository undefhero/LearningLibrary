package fib

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func TestFib(t *testing.T) {
	assert.Equal(t, 8, fib(6))
}
