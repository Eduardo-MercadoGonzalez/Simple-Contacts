package com.simplemobiletools.contacts.pro.robots

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.simplemobiletools.contacts.pro.R

/**
 * Description: Navigation Bar robots
 */

fun click(func: SelectButtonNavBarOptionRobot.() -> Unit) = SelectButtonNavBarOptionRobot().apply { func() }

class SelectButtonNavBarOptionRobot {

    fun clickOnButton(sectionName: String): SelectButtonNavBarOptionRobot {
        onView(withText(sectionName)).perform(click())
        return this
    }

    infix fun result(func: CheckViewResultRobot.() -> Unit): CheckViewResultRobot {
        return CheckViewResultRobot().apply { func() }
    }
}

class CheckViewResultRobot {

    fun contactsOK(): CheckViewResultRobot{
        onView(ViewMatchers.withId(R.id.contacts_fragment)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        return this
    }

    fun favoritesOK(): CheckViewResultRobot{
        onView(ViewMatchers.withId(R.id.favorites_fragment)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        return this
    }

    fun groupsOK(): CheckViewResultRobot{
        onView(ViewMatchers.withId(R.id.groups_fragment)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        return this
    }
}

