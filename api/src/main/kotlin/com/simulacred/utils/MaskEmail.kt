package com.simulacred.utils

fun String.maskEmail(): String {
    val regex = "([^@])[^@]+([^@]@)([^.]+)(\\..+)".toRegex()
    return replace(regex) { matchResult ->
        val userFirst = matchResult.groupValues[1]
        val userLast = matchResult.groupValues[2]
        val domain = matchResult.groupValues[3]
        val tld = matchResult.groupValues[4]

        val maskedUser = "$userFirst***$userLast"
        val maskedDomain = "*".repeat(domain.length)

        "$maskedUser$maskedDomain$tld"
    }
}
