import sys


# class ListNode(Object):
#     def __init__(self, v):
#         self.value = v
#         self.left = None
#         self.right = None


def main():
    for line in sys.stdin:
        line = line.replace('\n', '')
        line = line.split(' ')
        if len(line) != 1:
            print(problem4(line))

def problem1(num):
    num = [int(i) for i in num]
    n = num[0]
    right = len(num) - 1
    left = 1
    i = 0
    while left < right:
        i = left/right
        if i == num:
            return left, right
        if left/(right-1) < (left+1)/right:
            right -= 1
            continue
        if left/(right-1) > (left+1)/right:
            left -= 1
            continue

def problem4(num):
    l = []
    num = [int(i) for i in num]
    for m in range(1, len(num)):
        for n in range(m+1, len(num)):
            l.append(num[m]/num[n])
    list.sort(l)
    target = num[0]
    print(target)
    for m in range(1, len(num)):
        for n in range(m, len(num)):
            if num[m]/num[n] == l[target]:
                return num[m], num[n]

def problem2(num):
    num = [int(i) for i in num]
    if num[2] > num[1] and num[2] > num[0]:
        return 0
    if num[1] == num[2] or num[0] == num[2]:
        return 1
    m1 = max(num[0], num[1])
    m2 = min(num[0], num[1])
    if (m1 - m2) == num[2]:
        return 2
    i = 0
    while 1:
        if (m2 * i - m1) == num[2]:
            return i*2
        if (m2 * i - m1) > num[2]:
            break
        i += 1
    return 0


def calc_f(num):
    if num < 1024 and num > 0:
        return 1
    res = 0
    nums = []
    nums.append(num)
    while len(nums) > 0:
        n = nums.pop(0)
        if n >= 1024:
            nums.append(n - 1)
            nums.append(n - 1024)
        else:
            res += 1
    return res


def clac_ff(num):
    if num < 1024:
        return 1
    return clac_ff(num - 1) + clac_ff(num - 1024)


def permutations(str):
    l = len(str)
    if l == 0:
        return
    if l == 1:
        return str
    map = []
    res = []
    for i in range(l):
        if str[i] in map:
            continue
        map.append(str[i])
        for j in permutations(str[:i] + str[i + 1:]):
            res.append(str[i] + j)
    return res


def generateMatrix(self, n):
    left = top = 0
    right = n - 1
    bottom = n - 1
    num = 1
    result = [[0 for __ in range(n)] for __ in range(n)]
    while left < right and top < bottom:
        for i in range(left, right):
            result[top][i] = num
            num += 1
        for i in range(top, bottom):
            result[i][right] = num
            num += 1
        for i in range(right, left, -1):
            result[bottom][i] = num
            num += 1
        for i in range(bottom, top, -1):
            result[i][left] = num
            num += 1
        left += 1
        right -= 1
        top += 1
        bottom -= 1
    if left == right and top == bottom:
        result[top][left] = num
    return result


if __name__ == '__main__':
    main()
