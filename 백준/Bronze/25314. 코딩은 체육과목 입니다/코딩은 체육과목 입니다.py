number = int(input())

countLong = int(number / 4)

result = ''

for i in range(countLong - 1):
    result = 'long ' + result

if result == '':
    print('long int')
else:
    print(result + 'long int')
