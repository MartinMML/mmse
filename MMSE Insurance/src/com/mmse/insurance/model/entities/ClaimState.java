package com.mmse.insurance.model.entities;

/**
 * Enum used for defining the state of a claim (UnApproved by default)
 * @author Adam
 */
public enum ClaimState {
    UnApproved, Rejected, Registered, Clasified, CheckedInsurance, CheckedHistory, GarageCalled, Approved, Paid, LetterSent
}
