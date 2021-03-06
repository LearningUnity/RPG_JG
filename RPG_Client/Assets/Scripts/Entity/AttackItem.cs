﻿using UnityEngine;
using System.Collections;

public enum AttackType { Normal , Skill01, Skill02 , Skill03 };
public enum AttackDir { Forward , Around , Back};
public enum AttackStage { First , Second , Third};
public class AttackItem {

    private AttackType type = AttackType.Normal;
    private AttackDir attackDir = AttackDir.Around;
    private AttackStage stage = AttackStage.First;


    private float range = 10f;
    private float damage = 10;
    private float jumpHeight = 1f;
    private float jumpDuration = 2f;

    public AttackStage Stage
    {
        get { return stage; }
        set { stage = value; }
    }
    public float JumpDuration
    {
        get { return jumpDuration; }
        set { jumpDuration = value; }
    }

    public AttackDir AttackDir
    {
        get { return attackDir; }
        set { attackDir = value; }
    }

    public float Range
    {
        get { return range; }
        set { range = value; }
    }

    public float Damage
    {
        get { return damage; }
        set { damage = value; }
    }

    public AttackType Type
    {
        get { return type; }
        set { type = value; }
    }
    public float JumpHeight
    {
        get { return jumpHeight; }
        set { jumpHeight = value; }
    }
}
