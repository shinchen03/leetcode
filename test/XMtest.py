def p1(x):
    m = float('-inf')
    pre = 0
    temp = 0
    x.sort()
    for cur in x:
        if (cur - pre) == 1:
            temp += cur
        else:
            if temp > m:
                m = temp
            temp = cur
        pre = cur
    if temp > m:
        m = temp
    return m

def p2(test):
    f = float('-inf')
    s = float('-inf')
    for l in test:
        temp = p1(l)
        if s < temp:
            s = temp
            if f < s:
                s = f
                f = temp
    return s+f

def p3(test) :
    


if __name__ == '__main__':
    # argv = sys.argv
    # x = argv[1]
    test1 = [1, 1, -5, 6, 7, -2]
    print (p1(test1))

