package validpalindrome

import (
	"strings"
)

// func isPalindrome(s string) bool {
// 	if len(s) == 0 {
// 		return true
// 	}

// 	re := regexp.MustCompile("[^a-zA-Z0-9]")
// 	str := re.ReplaceAllString(s, "")
// 	str = strings.ToLower(str)

// 	if len(str) == 0 {
// 		return true
// 	}

// 	first, last := 0, len(str)-1

// 	for first < last {
// 		if str[first] != str[last] {
// 			return false
// 		}
// 		str = str[first+1 : last]
// 		last = len(str) - 1
// 	}

// 	return true
// }

func isPalindrome(s string) bool {
	if len(s) == 0 {
		return true
	}

	s = strings.ToLower(s)
	left, right := 0, len(s)-1

	for left < right {
		for left < right && !isAlphanumeral(s[left]) {
			left++
		}
		for left < right && !isAlphanumeral(s[right]) {
			right--
		}
		if left < right && !strings.EqualFold(string(s[left]), string(s[right])) {
			return false
		}
		left++
		right--
	}

	return true
}

func isAlphanumeral(b byte) bool {
	return (b >= 'a' && b <= 'z') || (b >= '0' && b <= '9')
}
