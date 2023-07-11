package com.simplemobiletools.contacts.pro.robots

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.espresso.matcher.ViewMatchers.withContentDescription
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import org.hamcrest.CoreMatchers.allOf
import com.simplemobiletools.contacts.pro.R
import com.simplemobiletools.contacts.pro.utils.AppButton

fun addContact(func: AddContactRobot.() -> Unit) = AddContactRobot().apply { func() }


class AddContactRobot {


    fun clickOnAdd(): AddContactRobot {
        onView(withText(AppButton.CONTACTS.buttonName)).perform(click())
        onView(allOf(withId(R.id.fragment_fab), withContentDescription("Create new contact"))).perform(click())
        return this
    }

    fun createContact(name: String, surname: String, phone:String):AddContactRobot {
        clickOnAdd()
        onView(withId(R.id.contact_first_name)).perform(typeText(name))
        onView(withId(R.id.contact_surname)).perform(typeText(surname))
        onView(withId(R.id.contact_number)).perform(typeText(phone))
        onView(withId(R.id.save)).perform(click())
        return this
    }

    fun removeContact(name: String, surname: String):AddContactRobot {
        onView(withText(AppButton.CONTACTS.buttonName)).perform(click())
        onView(withText(name.plus(' ').plus(surname))).perform(ViewActions.longClick())
        onView(withId(R.id.cab_edit)).perform(click())
        onView(withId(R.id.delete)).perform(click())
        onView(withText(AppButton.YES.buttonName)).perform(click())
        return this
    }

    infix fun result(func: CheckAddContactView.() -> Unit): CheckAddContactView {
        return CheckAddContactView().apply { func() }
    }
}

class CheckAddContactView {

    fun addContactViewOK() : CheckAddContactView {
        onView(withId(R.id.contact_holder)).check(matches(isDisplayed()))
        return this
    }

    fun addedContactOK(phone:String): CheckAddContactView {
        onView(withText(phone)).check(matches(isDisplayed()))
        return this
    }

}
