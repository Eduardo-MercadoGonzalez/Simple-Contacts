package com.simplemobiletools.contacts.pro.robots

import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.longClick
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*


import com.simplemobiletools.contacts.pro.R
import com.simplemobiletools.contacts.pro.utils.AppButton
import org.hamcrest.CoreMatchers
import org.hamcrest.Matchers.*
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matcher.*
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher


fun createGroup(func: AddGroupRobot.() -> Unit) = AddGroupRobot().apply { func() }

class AddGroupRobot {

    fun clickOnAddGroup(): AddGroupRobot {
        onView(withText(AppButton.GROUPS.buttonName)).perform(click())
        onView(CoreMatchers.allOf(withId(R.id.fragment_fab), withContentDescription(AppButton.NEW_GROUP_DESCRIPTION.buttonName)))
            .perform(click())
        return this
    }

    fun createGroup(name:String):AddGroupRobot{
        onView(withId(R.id.group_name)).perform(typeText(name))
        onView(withText(AppButton.OK.buttonName)).perform(click())
        return this
    }

    fun addContactToGroup(groupName: String, contactName: String, contactSurname: String): AddGroupRobot{
        onView(withText(AppButton.GROUPS.buttonName)).perform(click())
        onView(withText(groupName.plus(" (0)"))).perform(click())
        onView(withText(R.string.add_contacts)).perform(click())
        onView(withText(contactName.plus(" ").plus(contactSurname))).perform(click())
        onView(withText(AppButton.OK.buttonName)).perform(click())
        val appCompatImageButton = onView(
            allOf(
                childAtPosition(
                    allOf(
                        withId(R.id.group_contacts_toolbar),
                        childAtPosition(
                            withId(R.id.group_contacts_coordinator),
                            0
                        )
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        appCompatImageButton.perform(click())
        return this
    }

    fun removeGroup(name: String): AddGroupRobot {
        onView(withText(AppButton.GROUPS.buttonName)).perform(click())
        onView(withText(name.plus(" (0)"))).perform(longClick())
        onView(withId(R.id.cab_delete)).perform(click())
        onView(withText(AppButton.YES.buttonName)).perform(click())
        return this
    }

    infix fun result(func: CheckAddGroupView.() -> Unit): CheckAddGroupView {
        return CheckAddGroupView().apply { func() }
    }

    private fun childAtPosition(
        parentMatcher: Matcher<View>, position: Int
    ): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                    && view == parent.getChildAt(position)
            }
        }
    }

}

private fun ViewInteraction.perform(pressBack: Unit) {

}

class CheckAddGroupView {

    fun addGroupViewOK(): CheckAddGroupView {
        onView(withId(R.id.group_name)).check(matches(isDisplayed()))
        return this
    }

    fun checkGroupList(name: String): CheckAddGroupView {
        onView(withText(name.plus(" (0)"))).check(matches(isDisplayed()))
        return this
    }

    fun checkContactInGroup(groupName: String, contactName: String, contactSurname: String): CheckAddGroupView {
        onView(withText(AppButton.GROUPS.buttonName)).perform(click())
        onView(withText(groupName.plus(" (1)"))).perform(click())
        onView(withText(contactName.plus(" ").plus(contactSurname))).check(matches(isDisplayed()))
        return this
    }

}


