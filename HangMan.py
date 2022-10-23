import random
from variables import *
import time

print('Welcome to HangMan')
time.sleep(1)

if True:

    with open("list.txt") as f:
        for lines in f:
            a.append(lines)

    words = [string.replace("\n", "") for string in a]

    for i in range(len(b)):
        c = words.index(b[i])
        words.pop(c)

    game_word = random.randint(0, len(words))
    ActualWord = words[game_word]
    length = (len(ActualWord))


def draw():
    global counter
    global length
    for letter in ActualWord:
        word.append(letter)

    for loop_index in range(length):
        if word[loop_index] == ' ':
            blank_space.append(' ')
        elif word[loop_index] == '-':
            blank_space.append('-')
        elif word[loop_index] == '&':
            blank_space.append('&')
        else:
            blank_space.append('_')

        print(blank_space[loop_index], end='')


def hangman():
    global counter
    if counter == 0:
        print('__________',
              '\n|        |',
              '\n|        '
              '\n|'
              '\n|'
              '\n|'
              '\n|'
              '\n|'
              '\n')
    elif counter == 1:
        print('__________',
              '\n|        |',
              '\n|        O'
              '\n|        '
              '\n|'
              '\n|'
              '\n|'
              '\n|'
              '\n')
    elif counter == 2:
        print('__________',
              '\n|        |',
              '\n|        O'
              '\n|        |'
              '\n|'
              '\n|'
              '\n|'
              '\n|'
              '\n')

    elif counter == 3:
        print('__________',
              '\n|        |',
              '\n|        O'
              '\n|        |\ '
              '\n|'
              '\n|'
              '\n|'
              '\n|'
              '\n')

    elif counter == 4:
        print('__________',
              '\n|        |',
              '\n|        O'
              '\n|       /|\ '
              '\n|'
              '\n|'
              '\n|'
              '\n|'
              '\n')

    elif counter == 5:
        print('__________',
              '\n|        |',
              '\n|        O'
              '\n|       /|\ '
              '\n|        |'
              '\n|'
              '\n|'
              '\n|'
              '\n')

    elif counter == 6:
        print('__________',
              '\n|        |',
              '\n|        O'
              '\n|       /|\ '
              '\n|        |'
              '\n|       / '
              '\n|'
              '\n|'
              '\n')

    elif counter == 7:
        print('__________',
              '\n|        |',
              '\n|        O'
              '\n|       /|\ '
              '\n|        |'
              '\n|       / \ '
              '\n|'
              '\n|'
              '\n')


while True:

    hangman()
    draw()
    guess = input("\n\nEnter a letter:")
    if guess.upper() and guess.lower() not in word:
        counter += 1

    if guess.upper() and guess.lower() in word:
        both = True
        if both:
            index_upper = [i for i, x in enumerate(word) if x == guess.upper()]
            index_lower = [i for i, x in enumerate(word) if x == guess.lower()]

            for i in range(len(index_upper)):
                blank_space[index_upper[i]] = guess.upper()
                if word[-1] == '_' and word.index(guess.upper()) == -1:
                    blank_space[-1] = guess.upper()
            for i in range(len(index_lower)):
                blank_space[index_lower[i]] = guess.lower()
                if word[-1] == '_' and word.index(guess.lower()) == -1:
                    blank_space[-1] = guess.upper()

    if guess.upper() in word or guess.lower() in word:

        if guess.upper() in word:
            capitalize = True
            index = [i for i, x in enumerate(word) if x == guess.upper()]
        if guess.lower() in word:
            capitalize = False
            indices = [i for i, x in enumerate(word) if x == guess.lower()]

        if capitalize:
            for i in range(len(index)):
                blank_space[index[i]] = guess.upper()
                if word[-1] == '_' and word.index(guess.upper()) == -1:
                    blank_space[-1] = guess.upper()
        if not capitalize:
            for i in range(len(indices)):
                blank_space[indices[i]] = guess.lower()
                if word[-1] == '_' and word.index(guess.lower()) == -1:
                    blank_space[-1] = guess.lower()

    if word[0:length] == blank_space[0:length] or counter == 7:
        break

if counter >= 7:
    print(f'You lost the word is {ActualWord}')
else:
    print("YOU WIN!!")
