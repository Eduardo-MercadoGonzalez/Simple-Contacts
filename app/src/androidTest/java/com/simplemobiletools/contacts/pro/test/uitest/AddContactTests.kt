package com.simplemobiletools.contacts.pro.uitest

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.simplemobiletools.contacts.pro.activities.MainActivity
import com.simplemobiletools.contacts.pro.robots.addContact
import org.junit.After
import org.junit.Rule
import org.junit.Test


class AddContactTests {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    private val testContact = mapOf<String, String>("name" to "Nero", "surname" to "Wolf", "phone" to "3131231212" )

    /**
     * Test Url: https://amedeloitte.sharepoint.com/:x:/r/sites/Project305-Framework_Testing_Automation/Documents/Framework_Testing_Automation
     * Android-Simple Contacts-TCs/TC-2
     * Feature: text fields
     * Test Case: Contacts List shows the name of a newly added contact..
     * Preconditions: N/A
     */
    @Test
    fun createContactTest() {
        addContact { createContact("Nero", "Wolf", "3121231212") } result { addedContactOK("3121231212") }
    }

    @After
    fun removeContact(){
        addContact { testContact["name"]?.let { testContact["surname"]?.let { it1 -> removeContact(it, it1) } } }
    }

}
