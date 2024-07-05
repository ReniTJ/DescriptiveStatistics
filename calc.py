# Finding the Mean
def mean(data):
    s = 0  # Sum
    for value in data:
        v = int(value)
        s = s + v
    mean = s / len(data)
    return mean

# Finding the Max
def max(data):
    mx = int(data[0]) # Max
    for value in data:
        v = int(value)
        if v > mx:
            mx = v
    return mx

# Finding the Min
def min(data):
    mini = int(data[0]) # Min
    for value in data:
        v = int(value)
        if v < mini:
            mini = v
    return mini

# Finding the Standard Deviation
def standdev(data):
    m = mean(data) #Calling Mean Function
    variance_s = 0 #Variance Sum
    for value in data:
        v = int(value)
        variance_s += ((v-m)**2)
        variance = variance_s / len(data)
    return variance ** 0.5

# Finding the Skewness
def skewed(data):
    m = mean(data)
    st = standdev(data)
    skew_s = 0
    for value in data:
        v = int(value)
        skew_s += (((v-m)/st)**3)
        skew = skew_s / len(data)
    return skew

# Finding the Kurtosis
def kurtosis(data):
    m = mean(data)
    st = standdev(data)
    kurt_s = 0
    for value in data:
        v = int(value)
        kurt_s += (((v - m) / st) ** 4)
        kurt = (kurt_s / len(data)) - 3
    return kurt