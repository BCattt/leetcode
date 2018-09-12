CC          = gcc
CFLAGS      = -Wall -fPIC
LDFLAGS     = 
DEBUG       = -g
BINDIR      = ../bin

LONGEST_PALINDROME      = $(BINDIR)/longestPalindrome
LONGEST_PALINDROME_SRC  = longestPalindrome.c
LONGEST_PALINDROME_OBJS = $(LONGEST_PALINDROME_SRC:.c=.o)

ZIGZAGCONVERSION        = $(BINDIR)/zigzagconversion
ZIGZAGCONVERSION_SRC    = zigZagConversion.c
ZIGZAGCONVERSION_OBJS   = $(ZIGZAGCONVERSION_SRC:.c=.o)

REVERSEINTEGER          = $(BINDIR)/reverseInteger
REVERSEINTEGER_SRC      = reverseInteger.c
REVERSEINTEGER_OBJS     = $(REVERSEINTEGER_SRC:.c=.o)

PALINDROM_NUMBER        = $(BINDIR)/palindromNumber
PALINDROM_NUMBER_SRC    = palindromNumber.c
PALINDROM_NUMBER_OBJS   = $(PALINDROM_NUMBER_SRC:.c=.o)

MAX_AREA                = $(BINDIR)/maxArea
MAX_AREA_SRC            = maxArea.c
MAX_AREA_OBJS           = $(MAX_AREA_SRC:.c=.o)

INT_2_ROMAN             = $(BINDIR)/int2Roman
INT_2_ROMAN_SRC         = int2Roman.c
INT_2_ROMAN_OBJS        = $(INT_2_ROMAN_SRC:.c=.o)

all: $(LONGEST_PALINDROME)			\
	 $(ZIGZAGCONVERSION) 			\
	 $(REVERSEINTEGER)				\
	 $(PALINDROM_NUMBER)			\
	 $(MAX_AREA)					\
	 $(INT_2_ROMAN)					\

$(LONGEST_PALINDROME): $(LONGEST_PALINDROME_OBJS)
	$(CC) $(CCFLAGS) -o $(LONGEST_PALINDROME) $(LONGEST_PALINDROME_OBJS) $(LDFLAGS) $(DEBUG)

$(ZIGZAGCONVERSION): $(ZIGZAGCONVERSION_OBJS)
	$(CC) $(CCFLAGS) -o $(ZIGZAGCONVERSION) $(ZIGZAGCONVERSION_OBJS) $(LDFLAGS) $(DEBUG) -lm

$(REVERSEINTEGER): $(REVERSEINTEGER_OBJS)
	$(CC) $(CCFLAGS) -o $(REVERSEINTEGER) $(REVERSEINTEGER_OBJS) $(LDFLAGS) $(DEBUG)

$(PALINDROM_NUMBER): $(PALINDROM_NUMBER_OBJS)
	$(CC) $(CCFLAGS) -o $(PALINDROM_NUMBER) $(PALINDROM_NUMBER_OBJS) $(LDFLAGS) $(DEBUG)

$(MAX_AREA): $(MAX_AREA_OBJS)
	$(CC) $(CCFLAGS) -o $(MAX_AREA) $(MAX_AREA_OBJS) $(LDFLAGS) $(DEBUG)

$(INT_2_ROMAN): $(INT_2_ROMAN_OBJS)
	$(CC) $(CCFLAGS) -o $(INT_2_ROMAN) $(INT_2_ROMAN_OBJS) $(LDFLAGS) $(DEBUG)

clean :
		rm                                              		 \
		$(LONGEST_PALINDROME) $(LONGEST_PALINDROME_OBJS)		 \
		$(ZIGZAGCONVERSION) $(ZIGZAGCONVERSION_OBJS)			 \
		$(REVERSEINTEGER) $(REVERSEINTEGER_OBJS)				 \
		$(PALINDROM_NUMBER) $(PALINDROM_NUMBER_OBJS)			 \
		$(MAX_AREA) $(MAX_AREA_OBJS)							 \
		$(INT_2_ROMAN) $(INT_2_ROMAN_OBJS)						 \