package stack

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func TestStackPush(t *testing.T) {
	var stack Stack

	stack.Push("first")
	stack.Push("second")

	assert.Equal(t, 2, stack.Size())
	assert.Equal(t, "second", stack.Peek())
}

func TestStackPop(t *testing.T) {
	var stack Stack

	assert.Nil(t, stack.Pop())

	stack.Push("first")
	stack.Push("second")

	assert.Equal(t, "second", stack.Pop())
	assert.Equal(t, 1, stack.Size())
	assert.Equal(t, "first", stack.Pop())
	assert.Nil(t, stack.Pop())
}

func TestStackPeek(t *testing.T) {
	var stack Stack

	assert.Nil(t, stack.Peek())

	stack.Push("first")
	stack.Push("second")

	assert.Equal(t, "second", stack.Peek())
	assert.Equal(t, 2, stack.Size())
}

func TestStackIsEmpty(t *testing.T) {
	var stack Stack

	assert.True(t, stack.IsEmpty())

	stack.Push("item")
	assert.False(t, stack.IsEmpty())

	stack.Pop()
	assert.True(t, stack.IsEmpty())
}

func TestStackSize(t *testing.T) {
	var stack Stack

	assert.Equal(t, 0, stack.Size())

	stack.Push("first")
	stack.Push("second")
	assert.Equal(t, 2, stack.Size())

	stack.Pop()
	assert.Equal(t, 1, stack.Size())
}
