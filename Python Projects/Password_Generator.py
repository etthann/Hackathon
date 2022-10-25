import random

"""Goal create a password that includes: characters, alphabets and digits"""

length = input("How long would you like your password to be?")

digits = [0, 9, 8, 7, 6, 5, 4, 3, 2, 1]
characters = list("!()-_.?{}_`~;:@#$^&*+=")
lower_alphabets = list('abcdefghijklmnopqrstuvwxyz')
upper_alphabets = list('ABCDEFGHIJKLMNOPQRSTUVWXYZ')
choice = []
password = []

# Get a number between 1-3 to choose a list
for i in range(0, int(length)):
    category = random.randint(1, 4)
    choice.append(category)

# Access the list and get a random value from the list and add it to the password
for i in range(len(choice)):
    try:
        if choice[i] == 1:
            value = random.randint(0, len(digits))
            password.append(digits[value])

        elif choice[i] == 2:
            value = random.randint(0, len(characters))
            password.append(characters[value])
        elif choice[i] == 3:
            value = random.randint(0, len(lower_alphabets))
            password.append(lower_alphabets[value])
        elif choice[i] == 4:
            value = random.randint(0, len(upper_alphabets))
            password.append(upper_alphabets[value])
    except IndexError:
        pass

# Prints out the password
for i in range(len(password)):
    print(password[i], end='')
