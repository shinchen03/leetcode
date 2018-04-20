ans = 0
x = 1
y = 1
i = 0
n = 5
k = 2
time = 0
while x <= n:
    time += 1
    while y <= n:
        time += 1
        y = x * i + k
        # while y <= (i + 1) * x and y < n:
        #     i += 1
        #     time += 1
        # ans += (i + 1) * x - y + 1
        if y < (i + 1) * x and y < n:
            time += 1
            ans += (i + 1) * x - y + 1
            print(x, y)
        i += 1
    x = x + 1
    y = 0
    i = 0
print(ans)
print(time)

res = 0
time2 = 0
for i in range(k, n):
    time2 += 1
    res += n - i
j = n
while j > k:
    time2 += 1
    for z in range(k + 1, j):
        time2 += 1
        res += 1 if j % z >= k else 0
    j -= 1
print(res)
print(time2)
