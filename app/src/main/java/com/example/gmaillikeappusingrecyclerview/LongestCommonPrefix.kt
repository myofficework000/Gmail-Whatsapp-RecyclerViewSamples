package com.example.gmaillikeappusingrecyclerview

class LongestCommonPrefix {
}

fun longestCommonPrefix(strings: Array<String>): String {

    if (strings.isEmpty()) return ""
    if (strings.size == 1) return strings[0]

    strings.sort()

    for (i in strings[0].indices) {
        if (strings[0][i] != strings[strings.size - 1][i])
            return strings[0].substring(0, i)
    }
    return strings[0]
}

fun main() {
    println(longestCommonPrefix(arrayOf("avc", "av", "avce", "avcdfgg")))
    println(longestCommonPrefix(arrayOf("a", "av", "avce", "avcdfgg")))
    println(longestCommonPrefix(arrayOf("avc", "avc", "avce", "avcdfgg")))
}