﻿using UnityEngine;
using System.Collections;
using System.Collections.Generic;

public class TaskEntity{

    public const int NotClaim = 0;
    public const int NotComplete = 1;
    public const int Complete = 2;
    public const int Finish = 3;

    private int _id;
    private int _taskId;
    private string _name;
    private string _desc;
    private int _status;
    private string _iconName;
    private List<string> _talkNPC;
    private int _npc_id;
    private int _fb_id;
    private string _extra01;
    private string _extra02;
    private string _extra03;
    private int _goldCount;
    private int _diamondCount;
    private int _ownerId;
    private string type;
    private int _curStage;
    private int _totalStage;

    public int TotalStage
    {
        get { return _totalStage; }
        set { _totalStage = value; }
    }
    public int CurStage
    {
        get { return _curStage; }
        set { _curStage = value; }
    }
   


    public TaskEntity() { }
    public TaskEntity(TaskEntity task)
    {
        this.Id = task.Id;
        this.Name = task.Name;
        this.Desc = task.Desc;
        this.Status = task.Status;
        this.IconName = task.IconName;
        this.TalkNPC = task.TalkNPC;
        this.Npc_id = task.Npc_id;
        this.Fb_id = task.Fb_id;
        this.GoldCount = task.GoldCount;
        this.DiamondCount = task.DiamondCount;
        this.Extra01 = task.Extra01;
        this.Extra02 = task.Extra02;
        this.Extra03 = task.Extra03;
        this.OwnerId = task.OwnerId;
        this.Type = task.Type;
        this.CurStage = task.CurStage;
        this.TotalStage = task.TotalStage;
        this.TaskId = TaskId;
    }

    public int TaskId
    {
        get { return _taskId; }
        set { _taskId = value; }
    }
    public int Id
    {
        get
        {
            return _id;
        }

        set
        {
            _id = value;
        }
    }

    public string Name
    {
        get
        {
            return _name;
        }

        set
        {
            _name = value;
        }
    }

    public string Desc
    {
        get
        {
            return _desc;
        }

        set
        {
            _desc = value;
        }
    }

    public string IconName
    {
        get
        {
            return _iconName;
        }

        set
        {
            _iconName = value;
        }
    }

    public List<string> TalkNPC
    {
        get
        {
            return _talkNPC;
        }

        set
        {
            _talkNPC = value;
        }
    }

    public int Npc_id
    {
        get
        {
            return _npc_id;
        }

        set
        {
            _npc_id = value;
        }
    }

    public int Fb_id
    {
        get
        {
            return _fb_id;
        }

        set
        {
            _fb_id = value;
        }
    }

    public string Extra01
    {
        get
        {
            return _extra01;
        }

        set
        {
            _extra01 = value;
        }
    }

    public string Extra02
    {
        get
        {
            return _extra02;
        }

        set
        {
            _extra02 = value;
        }
    }

    public string Extra03
    {
        get
        {
            return _extra03;
        }

        set
        {
            _extra03 = value;
        }
    }

    public int GoldCount
    {
        get
        {
            return _goldCount;
        }

        set
        {
            _goldCount = value;
        }
    }

    public int DiamondCount
    {
        get
        {
            return _diamondCount;
        }

        set
        {
            _diamondCount = value;
        }
    }

    public int OwnerId
    {
        get
        {
            return _ownerId;
        }

        set
        {
            _ownerId = value;
        }
    }

    public string Type
    {
        get
        {
            return type;
        }

        set
        {
            type = value;
        }
    }

    public int Status
    {
        get
        {
            return _status;
        }

        set
        {
            _status = value;
        }
    }
}
